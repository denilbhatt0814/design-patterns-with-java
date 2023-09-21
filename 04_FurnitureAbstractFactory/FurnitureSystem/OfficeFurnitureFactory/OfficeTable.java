package FurnitureSystem.OfficeFurnitureFactory;

import FurnitureSystem.AbstractFurnitureFactory.Table;

public class OfficeTable implements Table {

    public int getPrice() {
        return 5000;
    }

    public String getInfo() {
        return "This is a Office Table";
    }

}
