package HouseSystem;

import java.util.ArrayList;
import java.util.List;

abstract public class House implements Cloneable {
    static private int count;
    protected int id;
    protected String area;
    protected int price;
    protected Address address;
    protected List<Facility> facilities = new ArrayList<Facility>();

    {
        this.id = count;
        count++;
    }

    public House(String area, int price, Address address, List<Facility> facilities) {
        this.area = area;
        this.price = price;
        this.address = address;
        this.facilities = facilities;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        House.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Facility[] getFacilities() {
        return (Facility[]) this.facilities.toArray();
    }

    public void addFacility(Facility facility) {

        this.facilities.add(facility);

    }

    public House clone() throws CloneNotSupportedException {
        House newHouse = (House) super.clone();
        Address newAddr = new Address(this.address.getCity(), this.address.getSocietyName());
        List<Facility> facilities = new ArrayList<Facility>(this.facilities);
        newHouse.address = newAddr;
        newHouse.facilities = facilities;
        return newHouse;
    }

    @Override
    public String toString() {
        return "House [id=" + id + ", area=" + area + ", price=" + price + ", address=" + address + ", facilities="
                + facilities + "]";
    }
}