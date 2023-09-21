import HouseSystem.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        HouseStore hs = new HouseStore();

        House sample2BHK = hs.getHouse("2BHK");
        House my2HBK = sample2BHK.clone();
        System.out.println("Sample: " + sample2BHK);
        System.out.println("Clone: " + my2HBK);

        System.out.println("-------- Modified address --------");
        my2HBK.getAddress().setCity("Ahmedabad");

        System.out.println("Sample: " + sample2BHK);
        System.out.println("Clone: " + my2HBK);

        System.out.println("-------- Modified Facilities --------");
        Facility newFacility1 = new Facility("Air filter", 50);
        my2HBK.addFacility(newFacility1);

        System.out.println("Sample: " + sample2BHK);
        System.out.println("Clone: " + my2HBK);
    }
}
