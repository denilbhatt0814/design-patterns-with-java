package IndustrySystem;

public class ContactDetails {
    String email;
    long phoneNo;
    String address;

    public ContactDetails(String email, long phoneNo, String address) {
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public String setEmail(String email) {
        this.email = email;
        return this.email;
    }

    public long getPhoneNo() {
        return this.phoneNo;
    }

    public long setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
        return this.phoneNo;
    }

    public String getAddress() {
        return this.address;
    }

    public String setAddress(String address) {
        this.address = address;
        return this.address;
    }

    public String toString() {
        return "ContactDetails [email=" + email + ", phoneNo=" + phoneNo + ", address=" + address + "]";
    }
}