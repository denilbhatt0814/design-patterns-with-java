package ComputerSystem;

abstract public class ComputerBuilder {
    protected Computer computer;

    public ComputerBuilder() {
        this.computer = new Computer();
    }

    public Computer getComputer() {
        return computer;
    }

    abstract public void configStorage();

    abstract public void configMemory();

    abstract public void configProcessor();

    abstract public void configCore();

    abstract public void configMonitorSize();

    abstract public void configMonitorType();

    abstract public void configOS();
}
