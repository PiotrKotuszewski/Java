package XorConstraints;

import java.time.LocalDate;

public class Person{
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private float salary;

    private Player player;
    private Arbiter arbiter;

    public Person(String firstName, String lastName, LocalDate birthDate, float salary, PersonType personType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;

        if(personType == PersonType.Player){
            this.player = new Player(this);
            this.arbiter = null;
        }else if(personType == PersonType.Arbiter){
            this.player = null;
            this.arbiter = new Arbiter(this);
        }
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        if(this.player != null)
            return player.toString();
        else
            return this.arbiter.toString();
    }
}
