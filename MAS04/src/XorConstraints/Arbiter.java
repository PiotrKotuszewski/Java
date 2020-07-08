package XorConstraints;

import java.time.LocalDate;

public class Arbiter{
    private Person person;

    public Arbiter(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Arbiter{" +
                "firstName=" + person.getFirstName() +
                ", lastName="+ person.getLastName()+
                ", birthDate="+ person.getBirthDate()+
                ", salary="+person.getSalary()+
                '}';
    }
}
