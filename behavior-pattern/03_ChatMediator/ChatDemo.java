import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String message, User user);

    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator {

    List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<User>();
    }

    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}

class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    public void send(String message) {
        System.out.println(this.name + " sends msg: " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + " receives msg: " + message);
    }
}

class ChatDemo {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new ChatUser(mediator, "User1");
        User user2 = new ChatUser(mediator, "User2");
        User user3 = new ChatUser(mediator, "User3");
        User user4 = new ChatUser(mediator, "User4");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hello, everyone!");
    }
}
