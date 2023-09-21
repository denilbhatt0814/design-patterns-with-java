package FurnitureSystem.ArtFurnitureFactory;

import FurnitureSystem.AbstractFurnitureFactory.Table;

public class ArtTable implements Table {

    public int getPrice() {
        return 7500;
    }

    public String getInfo() {
        return "This is an art style table";
    }

}
