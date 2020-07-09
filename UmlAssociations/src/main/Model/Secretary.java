package main.Model;

import java.io.Serializable;
import java.time.LocalDate;


public class Secretary implements Serializable {
    private String firstName;
    private String lastName;
    //Atrybut zlozony
    private LocalDate startYear;
    private double nextYearBonus;
    //Atrybut pochodny
    private double salary;
    //Atrybut klasowy
    private static final LocalDate yearToGetBonus = LocalDate.of(2017,1,1);
    private static final double bonus = 200;
    private Duty duty;


    public Secretary(String firstName, String lastName, LocalDate startYear, double salary, Duty duty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startYear = startYear;
        this.salary = salary + calculateRaise(startYear) + calculateRaise(salary);
        this.duty = duty;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getStartYear() {
        return startYear;
    }

    public void setStartYear(LocalDate startYear) {
        this.startYear = startYear;
    }

    public double getNextYearBonus() {
        return nextYearBonus;
    }

    public void setNextYearBonus(double nextYearBonus) {
        this.nextYearBonus = nextYearBonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Przeciazanie metod
    public double calculateRaise(LocalDate startJobYer){
        if(startJobYer.isBefore(yearToGetBonus))
            return bonus;
        else
            return 0;
    }

    public double calculateRaise(Double salary){
        if(salary < 2500.0)
            return bonus;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startYear=" + startYear +
                ", nextYearBonus=" + nextYearBonus +
                ", salary=" + salary +
                '}';
    }
}
