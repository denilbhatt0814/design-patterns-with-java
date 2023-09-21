import java.util.ArrayList;

import java.util.List;

class SubjectEntity {
    private int numberState;
    private List<ObserverEntity> lm = new ArrayList<ObserverEntity>();

    public void setNumberState(int n) {
        numberState = n;
        notifyAllObservers();
    }

    public int getNumberState() {
        return numberState;
    }

    public void registerObserver(ObserverEntity e) {
        lm.add(e);
    }

    public void unregisterObserver(ObserverEntity e) {
        lm.remove(e);
    }

    public void notifyAllObservers() {
        System.out.println("Number has been updated");
        for (ObserverEntity o : lm) {
            o.update();
        }
    }
}

abstract class ObserverEntity {

    SubjectEntity se; // re

    abstract public void update();
}

class BinaryObeserverEntity extends ObserverEntity {
    public BinaryObeserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberState();
        System.out.println("Representing number: " + n + " to binary: " + Integer.toBinaryString(n));
    }
}

class HexObeserverEntity extends ObserverEntity {
    public HexObeserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberState();
        System.out.println("Representing number: " + n + " to hex: " + Integer.toHexString(n));
    }
}

class OctalObeserverEntity extends ObserverEntity {
    public OctalObeserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberState();
        System.out.println("Representing number: " + n + " to oct: " + Integer.toOctalString(n));
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        SubjectEntity se = new SubjectEntity();
        ObserverEntity o1 = new BinaryObeserverEntity(se);
        ObserverEntity o2 = new HexObeserverEntity(se);
        ObserverEntity o3 = new OctalObeserverEntity(se);
        se.setNumberState(12);
        se.registerObserver(o1);
        se.registerObserver(o2);
        se.registerObserver(o3);
        se.setNumberState(9);
    }
}