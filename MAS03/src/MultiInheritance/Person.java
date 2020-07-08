package MultiInheritance;

import java.time.LocalDate;

public abstract class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate contractEnd;

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate contractEnd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.contractEnd = contractEnd;
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

    public LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
    }

    public abstract float getIncome();

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
