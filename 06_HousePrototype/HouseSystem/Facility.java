package HouseSystem;

public class Facility {
    protected String name;
    protected int charge;

    public Facility(String name, int charge) {
        this.name = name;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "Facility [name=" + name + ", charge=" + charge + "]";
    }
}
