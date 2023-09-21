import BankerSystem.*;

public class Main {
    public static void performTask() {
        Banker banker = Banker.getBankerInstance();
        banker.createAccount("Eagle", 4500);
        banker.createAccount("Ghost", 700);
        System.out.println(banker);
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            public void run() {
                performTask();
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                performTask();
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
