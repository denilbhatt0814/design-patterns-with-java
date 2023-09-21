package HouseSystem;

import java.util.List;

public class TwoBHKHouse extends House {
    protected int parkingCharge;

    public TwoBHKHouse(String area, int price, Address address, int parkingCharge, List<Facility> facilities) {
        super(area, price, address, facilities);
        this.parkingCharge = parkingCharge;
    }

    public int getParkingCharge() {
        return parkingCharge;
    }

    public void setParkingCharge(int parkingCharge) {
        this.parkingCharge = parkingCharge;
    }
}
