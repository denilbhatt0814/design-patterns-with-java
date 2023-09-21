package ComputerSystem;

public class HardwareEngineer {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder cb) {
        computerBuilder = cb;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void buildComputer() {
        computerBuilder.configCore();
        computerBuilder.configMemory();
        computerBuilder.configMonitorSize();
        computerBuilder.configMonitorType();
        computerBuilder.configOS();
        computerBuilder.configProcessor();
        computerBuilder.configStorage();
    }

}
