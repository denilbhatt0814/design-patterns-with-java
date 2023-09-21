package ComputerSystem;

public class PersonalComputerBuiilder extends ComputerBuilder {
    public void configStorage() {
        computer.setStorage(1000);
    }

    public void configMemory() {
        computer.setMemory(16);
    }

    public void configProcessor() {
        computer.setProcessor("AMD");
    }

    public void configCore() {
        computer.setCore("Quad");
    }

    public void configMonitorSize() {
        computer.setMonitorSize(14);
    }

    public void configMonitorType() {
        computer.setMonitorType("OLED");
    }

    public void configOS() {
        computer.setOs("Windows 11");
    }
}
