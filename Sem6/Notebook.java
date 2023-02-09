package Sem6;

public class Notebook {
    protected String model;
    protected String color;
    protected String diagonal;
    protected String cpu;
    protected String gpu;
    protected String ram;
    protected String hdd;
    protected String os;

    public Notebook(String model, String color, String diagonal,
            String cpu, String gpu, String ram, String hdd, String os) {
        this.model = model;
        this.color = color;
        this.diagonal = diagonal;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
    }

    public String toString() {
        return this.model + " " +
                this.color + " " +
                this.diagonal + " " +
                this.cpu + " " +
                this.gpu + " " +
                this.ram + " " +
                this.hdd + " " +
                this.os;
    }

    public String getParam(String param) {
        switch (param) {
            case "model":
                return this.model;
            case "color":
                return this.color;
            case "diagonal":
                return this.diagonal;
            case "cpu":
                return this.cpu;
            case "gpu":
                return this.gpu;
            case "ram":
                return this.ram;
            case "hdd":
                return this.hdd;
            case "os":
                return this.os;
        }
        return "";
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public String getDiagonal() {
        return this.diagonal;
    }

    public String getcpu() {
        return this.cpu;
    }

    public String getGpu() {
        return this.gpu;
    }

    public String getRam() {
        return this.ram;
    }

    public String getHdd() {
        return this.hdd;
    }

    public String getOs() {
        return this.os;
    }

    public void setModel(String model) {
        this.model = model;
        return;
    }

    public void setColor(String color) {
        this.color = color;
        return;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
        return;
    }

    public void setcpu(String cpu) {
        this.cpu = cpu;
        return;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
        return;
    }

    public void setRam(String ram) {
        this.ram = ram;
        return;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
        return;
    }

    public void setOs(String os) {
        this.os = os;
        return;
    }
}