package BankerSystem;

import java.util.ArrayList;
import java.util.List;

public class Banker {
    private static Banker banker = null;
    private String name = "Bob";
    private List<Account> accounts = new ArrayList<Account>();

    private Banker() {
        System.out.println("Instanciating banker....");
    }

    public static synchronized Banker getBankerInstance() {
        if (banker == null) {
            banker = new Banker();
        }
        return banker;
    }

    public String getName() {
        return this.name;
    }

    public String setAcount() {
        return this.name;
    }

    public Account createAccount(String holder, int balance) {
        Account newAcc = new Account(holder, balance);
        accounts.add(newAcc);
        return newAcc;
    }

    public String toString() {
        return "Banker [iam=" + banker.hashCode() + " name=" + name + ", accounts=" + accounts + "]";
    }
}