import ComputerSystem.*;

public class Main {
    public static void main(String[] args) {
        HardwareEngineer he = new HardwareEngineer();

        ComputerBuilder personalCompBuilder = new PersonalComputerBuiilder();

        he.setComputerBuilder(personalCompBuilder);
        he.buildComputer();

        Computer myPC = he.getComputer();

        System.out.println(myPC);

    }
}
