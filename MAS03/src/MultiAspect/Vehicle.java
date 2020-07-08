package MultiAspect;

public abstract class Vehicle {
    private String brand;
    private String model;
    private String registerNr;

    public Vehicle(String brand, String model, String registerNr) {
        this.brand = brand;
        this.model = model;
        this.registerNr = registerNr;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegisterNr() {
        return registerNr;
    }

    public void setRegisterNr(String registerNr) {
        this.registerNr = registerNr;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registerNr='" + registerNr + '\'' +
                '}';
    }
}
