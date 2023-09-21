package ComputerSystem;

public class Computer {
    private int storage;
    private int memory;
    private String processor;
    private String core; // single, dual, quadCore
    private double monitorSize;
    private String monitorType;
    private String os;

    // Getter and setters
    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public double getMonitorSize() {
        return monitorSize;
    }

    public void setMonitorSize(double monitorSize) {
        this.monitorSize = monitorSize;
    }

    public String getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer [storage=" + storage + ", memory=" + memory + ", processor=" + processor + ", core=" + core
                + ", monitorSize=" + monitorSize + ", monitorType=" + monitorType + ", os=" + os + "]";
    }
}