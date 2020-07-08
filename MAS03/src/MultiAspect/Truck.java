package MultiAspect;

public class Truck extends Vehicle{
    private float capacity;

    public Truck(String brand, String model, String registerNr, float capacity) {
        super(brand, model, registerNr);
        this.capacity = capacity;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                '}';
    }
}
