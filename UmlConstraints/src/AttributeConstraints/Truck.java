package AttributeConstraints;

public class Truck {
    private float capacity;
    private String registerNr;

    private final static float maxCapacity = 10000f;
    private final static float minProfitable = 1000f;

    public Truck(float capacity, String registerNr) {
        this.capacity = capacity;
        this.registerNr = registerNr;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) throws Exception {
        if(capacity > maxCapacity)
            throw new Exception(String.format("Maksymalna ladownosc (%s).", maxCapacity));
        else if(capacity < minProfitable)
            throw new Exception(String.format("Ladownosc ponizej %s, nie oplaca sie naszej firmie.", minProfitable));
        this.capacity = capacity;
    }

    public String getRegisterNr() {
        return registerNr;
    }

    public void setRegisterNr(String registerNr) {
        this.registerNr = registerNr;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                ", registerNr='" + registerNr + '\'' +
                '}';
    }
}
