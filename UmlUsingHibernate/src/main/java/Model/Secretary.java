package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "secretary")
public class Secretary extends Person implements Serializable {

    private Long id;
    private LocalDate startJobYear;
    private double salary;
    private static final LocalDate dataToBenefits = LocalDate.of(2017, 1,1);

    public Secretary(){}

    public Secretary(String firstName, String lastName, LocalDate birthDate, LocalDate startJobYear, double salary) {
        super(firstName, lastName, birthDate);
        this.startJobYear = startJobYear;
        //Atrybut pochodny
        this.salary = salary + this.calculateRaise(startJobYear);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public LocalDate getstartJobYear() {
        return startJobYear;
    }

    public void setstartJobYear(LocalDate startJobYear) {
        this.startJobYear = startJobYear;
    }

    @Basic
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateRaise(LocalDate startJobYear){
        double bonus;
        if(startJobYear.isBefore(dataToBenefits))
            bonus = 200.0;
        else
            bonus = 0;
        return bonus;
    }

    //Metoda klasowa
    @Override
    public String toString() {
        return "Secretary{" +
                "id=" + id +
                ", startJobYear=" + startJobYear +
                ", salary=" + salary +
                '}';
    }
}
