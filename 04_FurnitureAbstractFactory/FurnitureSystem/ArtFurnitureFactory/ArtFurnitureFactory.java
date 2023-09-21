package FurnitureSystem.ArtFurnitureFactory;

import FurnitureSystem.AbstractFurnitureFactory.*;

public class ArtFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ArtChair();
    }

    public Table createTable() {
        return new ArtTable();
    }
}
