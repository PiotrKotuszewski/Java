package MultiInheritance;

import java.time.LocalDate;

public class Player extends Person {
    private String position;
    private int number;
    private float salary;
    private float advertisingIncome;

    public Player(String firstName, String lastName, LocalDate birthDate, LocalDate contractEnd, String position, int number, float salary, float advertisingIncome) {
        super(firstName, lastName, birthDate, contractEnd);
        this.position = position;
        this.number = number;
        this.salary = salary;
        this.advertisingIncome = advertisingIncome;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getAdvertisingIncome() {
        return advertisingIncome;
    }

    public void setAdvertisingIncome(float advertisingIncome) {
        this.advertisingIncome = advertisingIncome;
    }

    @Override
    public float getIncome() {
        return getSalary()+getAdvertisingIncome();
    }
}
