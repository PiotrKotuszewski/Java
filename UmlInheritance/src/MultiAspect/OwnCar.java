package MultiAspect;

public class OwnCar {
    private float price;

    public OwnCar(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OwnCar{" +
                "price=" + price +
                '}';
    }
}
