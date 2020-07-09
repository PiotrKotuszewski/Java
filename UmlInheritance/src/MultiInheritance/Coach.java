package MultiInheritance;

import java.time.LocalDate;

public class Coach extends Person {
    private float salary;
    private String favouriteFormation;

    public Coach(String firstName, String lastName, LocalDate birthDate, LocalDate contractEnd, float salary, String favouriteFormation) {
        super(firstName, lastName, birthDate, contractEnd);
        this.salary = salary;
        this.favouriteFormation = favouriteFormation;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getFavouriteFormation() {
        return favouriteFormation;
    }

    public void setFavouriteFormation(String favouriteFormation) {
        this.favouriteFormation = favouriteFormation;
    }

    @Override
    public float getIncome() {
        return getSalary();
    }
}
