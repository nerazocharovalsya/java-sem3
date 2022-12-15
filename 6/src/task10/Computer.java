package task10;

public class Computer {
    private Memory memory = new Memory();
    private Processor processor = new Processor();
    private Monitor monitor = new Monitor();
    private names name;

    public Computer(names name) {
        this.name = name;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public names getName() {
        return name;
    }

    public void setName(names name) {
        this.name = name;
    }
}
