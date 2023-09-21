package FurnitureSystem.OfficeFurnitureFactory;

import FurnitureSystem.AbstractFurnitureFactory.Chair;

public class OfficeChair implements Chair {

    public int getPrice() {
        return 2500;
    }

    public String getInfo() {
        return "This is a Office Chair";
    }

}
