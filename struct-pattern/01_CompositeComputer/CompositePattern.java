import java.util.ArrayList;
import java.util.List;

abstract class Component {
    protected String name;

    public Component(String n) {
        name = n;
    }

    public abstract void describeComponent();

    public abstract int getPrice();
}

class Leaf extends Component {
    protected int price;

    public Leaf(String n, int p) {
        super(n);
        price = p;
    }

    public void describeComponent() {
        System.out.print(name + " ");
    }

    public int getPrice() {
        return price;
    }
}

class Composite extends Component {
    List<Component> ls = new ArrayList<Component>();

    public Composite(String n) {
        super(n);
    }

    public void addComponent(Component c) {
        ls.add(c);
    }

    public void removeComponent(Component c) {
        ls.remove(c);
    }

    public List<Component> componentList() {
        return ls;
    };

    public void describeComponent() {
        System.out.print(name + " contains: [ ");
        for (Component c : ls) {
            c.describeComponent();
        }
        System.out.print(" ]");
    }

    public int getPrice() {
        int p = 0;
        for (Component c : ls) {
            p += c.getPrice();
        }
        return p;
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Component l1 = new Leaf("HDD", 8000);
        Component l2 = new Leaf("RAM", 4000);
        Component l3 = new Leaf("CPU", 35000);
        Component l4 = new Leaf("MOUSE", 1500);
        Component l5 = new Leaf("KEYBOARD", 3500);

        Composite c1 = new Composite("Computer");
        Composite c2 = new Composite("Cabinet");
        Composite c3 = new Composite("Peripherals");
        Composite c4 = new Composite("Motherboard");

        c1.addComponent(c2);
        c1.addComponent(c3);

        c2.addComponent(l1);
        c2.addComponent(c4);

        c4.addComponent(l3);
        c4.addComponent(l2);

        c3.addComponent(l4);
        c3.addComponent(l5);

        c1.describeComponent();

        System.out.println(" " + c2.name + " : " + c2.getPrice());
    }
}