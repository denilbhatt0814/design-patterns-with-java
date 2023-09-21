package FurnitureSystem.ArtFurnitureFactory;

import FurnitureSystem.AbstractFurnitureFactory.Chair;

public class ArtChair implements Chair {

    public int getPrice() {
        return 5000;
    }

    public String getInfo() {
        return "This is an art style chair";
    }

}
