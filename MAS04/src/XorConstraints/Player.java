package XorConstraints;

import java.time.LocalDate;

public class Player{
    private String position;
    private int number;
    private Person person;

    public Player(Person person) {
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
        return "Player{" +
                "firstName=" + person.getFirstName() +
                ", lastName="+ person.getLastName()+
                ", birthDate="+ person.getBirthDate()+
                ", salary="+person.getSalary()+
                '}';
    }
}
