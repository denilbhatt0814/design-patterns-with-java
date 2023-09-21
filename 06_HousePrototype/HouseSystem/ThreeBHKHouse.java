package HouseSystem;

import java.util.List;

public class ThreeBHKHouse extends House {
    protected int furnitureCharge;

    public ThreeBHKHouse(String area, int price, Address address, int furnitureCharge, List<Facility> facilities) {
        super(area, price, address, facilities);
        this.furnitureCharge = furnitureCharge;
    }

    public int getFurnitureCharge() {
        return furnitureCharge;
    }

    public void setFurnitureCharge(int furnitureCharge) {
        this.furnitureCharge = furnitureCharge;
    }
}
