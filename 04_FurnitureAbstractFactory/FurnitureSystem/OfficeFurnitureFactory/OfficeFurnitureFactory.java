package FurnitureSystem.OfficeFurnitureFactory;

import FurnitureSystem.AbstractFurnitureFactory.*;

public class OfficeFurnitureFactory implements FurnitureFactory {

    public Chair createChair() {
        return new OfficeChair();
    }

    public Table createTable() {
        return new OfficeTable();
    }

}
