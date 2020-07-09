package MultiInheritance;

public interface IPlayer {
    public abstract float getIncome();
    public abstract float getAdvertisingIncome();
    public abstract void setAdvertisingIncome(float advertisingIncome);
    public abstract void setPosition(String position);
    public abstract String getPosition();
    public abstract void setNumber(int number);
    public abstract int getNumber();
    public abstract float getSalary();
    public abstract void setSalary(float salary);
}
