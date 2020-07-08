package MultiAspect;

public class LeasingCar {
    private float leasingInstallment;

    public LeasingCar(float leasingInstallment) {
        this.leasingInstallment = leasingInstallment;
    }

    public float getLeasingInstallment() {
        return leasingInstallment;
    }

    public void setLeasingInstallment(float leasingInstallment) {
        this.leasingInstallment = leasingInstallment;
    }

    @Override
    public String toString() {
        return "LeasingCar{" +
                "leasingInstallment=" + leasingInstallment +
                '}';
    }
}
