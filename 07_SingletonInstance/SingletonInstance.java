class SingletonInstance {
    // private static final SingletonInstance singletonInstance = new
    // SingletonInstance(); // Eager initialization

    // static{
    // singletonInstance = new SingletonInstance();
    // }

    private static SingletonInstance singletonInstance = null;

    private SingletonInstance() {
        System.out.println("Creating singleton instance...");
    }

    // lazy initialization
    public static SingletonInstance getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SingletonInstance();
        }
        return singletonInstance;
    }
}

class ClassSingletonImpl {
    public static void main(String[] args) {
        SingletonInstance s1 = SingletonInstance.getInstance();
        SingletonInstance s2 = SingletonInstance.getInstance();

        System.out.println(s1);
        System.out.println(s2);
    }
}