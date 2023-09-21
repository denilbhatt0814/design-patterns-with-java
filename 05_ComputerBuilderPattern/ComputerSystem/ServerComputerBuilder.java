package ComputerSystem;

public class ServerComputerBuilder extends ComputerBuilder {
    public void configStorage() {
        computer.setStorage(4096);
    }

    public void configMemory() {
        computer.setMemory(64);
    }

    public void configProcessor() {
        computer.setProcessor("AMD Threadripper");
    }

    public void configCore() {
        computer.setCore("Octa");
    }

    public void configMonitorSize() {
        computer.setMonitorSize(0);
    }

    public void configMonitorType() {
        computer.setMonitorType(null);
    }

    public void configOS() {
        computer.setOs("Ubuntu 22.04 LTS");
    }
}
