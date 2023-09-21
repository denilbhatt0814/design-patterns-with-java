import java.util.*;

abstract class Component {
    protected String name;

    public Component(String n) {
        name = n;
    }

    public abstract void describeItem(int tabC);

    public abstract int getSize();
}

class File extends Component {
    protected String type;
    protected int size;

    File(String n, String t, int s) {
        super(n);
        type = t;
        size = s;
    }

    public void describeItem(int tabC) {
        System.out.print("📄 " + name + "." + type + " (" + this.getSize() + "kB)\n");
    }

    public int getSize() {
        return size;
    }
}

class Folder extends Component {
    List<Component> folderComponents = new ArrayList<Component>();

    Folder(String n) {
        super(n);
    }

    public void addComponent(Component c) {
        folderComponents.add(c);
    }

    public void removeComponent(Component c) {
        folderComponents.remove(c);
    }

    public void describeItem(int tabC) {
        System.out.println("📁 " + name + " (" + this.getSize() + "kB)");
        tabC++;
        for (Component c : folderComponents) {

            for (int i = 0; i < tabC; i++)
                System.out.print("\t");
            System.out.print("|-- ");
            c.describeItem(tabC);
        }
        System.out.println();

    }

    public int getSize() {
        int s = 0;
        for (Component c : folderComponents) {
            s += c.getSize();
        }
        return s;
    }
}

public class FMS {
    public static void main(String[] args) {
        Component file1 = new File("java-note", "txt", 5);
        Component file2 = new File("j-lecture-1", "pdf", 15);
        Component file3 = new File("cpp-note", "note", 5);
        Component file4 = new File("cpp-lecture-1", "pdf", 15);
        Component file5 = new File("syllabus", "ppt", 30);

        Folder folder1 = new Folder("College");
        Folder folder2 = new Folder("Java");
        Folder folder3 = new Folder("CPP");

        folder1.addComponent(folder2);
        folder1.addComponent(folder3);
        folder1.addComponent(file5);

        folder2.addComponent(file1);
        folder2.addComponent(file2);

        folder3.addComponent(file3);
        folder3.addComponent(file4);

        folder1.describeItem(0);
    }
}
