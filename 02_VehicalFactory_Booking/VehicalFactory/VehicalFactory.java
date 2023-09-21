package VehicalFactory;

public class VehicalFactory {
    public Vehical createVehical(String vehical) {
        switch (vehical) {
            case "AUTO":
                return new Auto();

            case "CAR":
                return new Car();

            default:
                System.out.println("No such vehical exists");
                return null;
        }
    }
}
