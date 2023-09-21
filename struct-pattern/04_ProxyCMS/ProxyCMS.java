import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

interface CustomerServiceDatabase {
    public Customer getCustomerDetails(String custId);
}

class CustomerService implements CustomerServiceDatabase {
    public Customer getCustomerDetails(String custId) {
        // readfile
        FileReader fr;
        try {
            fr = new FileReader("customerinfo.txt");
            BufferedReader bf = new BufferedReader(fr);
            while (bf.ready()) {
                String readData = bf.readLine();
                String[] data = readData.split(" ");
                Customer c = new Customer(data[0], data[1], data[2], data[3]);
                if (c.custId.equals(custId)) {
                    return c;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        // search for the custId if exist return cutomer deatils

        // else record not found.
    }
}

class Customer {
    String custId, custName, custEmail, custCity;

    public Customer(String custId, String custName, String custEmail, String custCity) {
        this.custId = custId;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custCity = custCity;
    }

    public String toString() {
        return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custCity="
                + custCity + "]";
    }
}

// -------------------------
class CustomerServiceProxy implements CustomerServiceDatabase {
    User connectedUser;
    CustomerService cs = new CustomerService();

    public CustomerServiceProxy(User u) {
        this.connectedUser = u;
    }

    public Customer getCustomerDetails(String custId) {
        if (connectedUser.role.equals("ADMIN")) {
            Customer c = cs.getCustomerDetails(custId);
            log("CMS.log", "OK", "FETCH", connectedUser, "read details of " + custId + "\n");
            return c;
        }
        // write user info to logCustomerDatabase.txt

        // If user role is "Admin" then forward the request

        // Else message access is denied
        System.out.println("Access denied!!");
        log("CMS.log", "ERR", "FETCH", connectedUser, "read details of " + custId + "\n");
        return null;
    }

    public void log(String filename, String status, String method, User user, String data) {
        try {

            BufferedWriter fw = new BufferedWriter(
                    new FileWriter(filename, true));
            String str = status + " " + LocalDateTime.now().toString() + " " + method + "  by " + user.username + " ["
                    + user.role
                    + "] : "
                    + data;
            fw.append(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    String username, role;

    public static User login(String username, String password) {
        // readfile
        FileReader fr;
        try {
            fr = new FileReader("users.txt");
            BufferedReader bf = new BufferedReader(fr);
            while (bf.ready()) {
                String readData = bf.readLine();
                String[] data = readData.split(" ");
                if (password.equals(data[2])) {
                    User u = new User(data[1], data[3]);
                    return u;
                }
            }
            System.out.println("USERNAME OR PWD INVALID");
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String toString() {
        return "User [username=" + username + ", role=" + role + "]";
    }
}

class ClientProxyPattern {
    public static void main(String[] args) {
        User u1 = User.login("lynx", "mypassword");
        CustomerServiceDatabase csd = new CustomerServiceProxy(u1);
        Customer c1 = csd.getCustomerDetails("CU101");
        System.out.println(c1);
        User u2 = User.login("nobita", "mypassword1");
        CustomerServiceDatabase csd2 = new CustomerServiceProxy(u2);
        Customer c2 = csd2.getCustomerDetails("CU101");
        System.out.println(c2);
        User u3 = User.login("nobita", "mypassword3");
    }
}