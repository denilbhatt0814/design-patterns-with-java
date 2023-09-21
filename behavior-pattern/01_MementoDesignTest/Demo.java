import java.util.ArrayList;
import java.util.List;

class OriginatorObject {
    private int temprature;
    private int volume;

    public OriginatorObject(int t, int v) {
        temprature = t;
        volume = v;
    }

    public int getTemprature() {
        return temprature;
    }

    public void setTemprature(int temprature) {
        this.temprature = temprature;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public MementoObject saveObjectState() {
        return new MementoObject(temprature, volume);
    }

    public void restoreObjectState(MementoObject m) {
        temprature = m.getTemprature();
        volume = m.getVolume();
    }

    public void operateMachine() {
        System.out.println("OriginatorObject [temprature=" + temprature + ", volume=" + volume + "]");
        ;
    }
}

class MementoObject {
    private int temprature;
    private int volume;

    public MementoObject(int t, int v) {
        temprature = t;
        volume = v;
    }

    public int getTemprature() {
        return temprature;
    }

    public int getVolume() {
        return volume;
    }
}

class CareTakerObject {
    List<MementoObject> lm = new ArrayList<MementoObject>();

    public void addMementoObject(MementoObject m) {
        lm.add(m);
    }

    public MementoObject getMementoObject(int i) {
        return lm.get(i);
    }
}

class Demo {
    public static void main(String[] args) {
        OriginatorObject o1 = new OriginatorObject(20, 10);
        o1.operateMachine();
        CareTakerObject c = new CareTakerObject();
        c.addMementoObject(o1.saveObjectState());

        // UPDATES
        o1.setTemprature(69);
        o1.setVolume(21);
        System.out.print("UPDATE:");
        o1.operateMachine();
        c.addMementoObject(o1.saveObjectState());

        o1.setTemprature(80);
        o1.setVolume(30);
        System.out.print("UPDATE:");
        o1.operateMachine();
        c.addMementoObject(o1.saveObjectState());

        // RESTORE
        o1.restoreObjectState(c.getMementoObject(0));
        System.out.println("Resotring.....");
        o1.operateMachine();
    }
}