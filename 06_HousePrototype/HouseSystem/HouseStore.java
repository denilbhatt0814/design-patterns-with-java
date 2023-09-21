package HouseSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HouseStore {
    protected static HashMap<String, House> houseRegistry = new HashMap<String, House>();

    static {
        houseRegistry.put("2BHK", new TwoBHKHouse("good", 1000, new Address("Gandhinagar", "Raisan"), 50,
                new ArrayList<Facility>(Arrays.asList(new Facility("AC - 1.5 ton", 120)))));
        houseRegistry.put("3BHK", new ThreeBHKHouse("good", 1000, new Address("Gandhinagar", "Raisan"), 500,
                new ArrayList<Facility>(Arrays.asList(new Facility("AC - 2 ton", 150)))));
    }

    public House getHouse(String type) {
        return houseRegistry.get(type);
    }
}
