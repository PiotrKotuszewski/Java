package MultiAspect;

public class Car extends Vehicle{
    private int seatsNr;

    public Car(String brand, String model, String registerNr, int seatsNr) {
        super(brand, model, registerNr);
        this.seatsNr = seatsNr;
    }

    public int getSeatsNr() {
        return seatsNr;
    }

    public void setSeatsNr(int seatsNr) {
        this.seatsNr = seatsNr;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatsNr=" + seatsNr +
                '}';
    }
}
