package BankerSystem;

public class Account {
    private static int count = 0;
    private int number;
    private String holder;
    private long balance;

    {
        number = ++count;
    }

    public Account(String holder, long balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Account [number=" + number + ", holder=" + holder + ", balance=" + balance + "]";
    }
}
