package Overlapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

enum PersonType {Person, Client, Dentist, Secretary};

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private List<String> dyploms;

    private String pesel;

    private EnumSet<PersonType> personTypes = EnumSet.of(PersonType.Person);

    public Person(String firstName, String lastName, LocalDate birthDate, List<String> dyploms, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.dyploms = dyploms;
        this.pesel = pesel;

        personTypes.add(PersonType.Client);
        personTypes.add(PersonType.Dentist);
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

    public List<String> hasDyploms() throws Exception{
        if(personTypes.contains(PersonType.Dentist))
            return dyploms;
        throw new Exception("The person is not a dentist");
    }

    public void setDyploms(List<String> dyploms) throws Exception{
        if(personTypes.contains(PersonType.Dentist))
            this.dyploms = dyploms;
        else
            throw new Exception("The person is not a dentist");
    }

    public String getPesel() throws Exception{
        if(personTypes.contains(PersonType.Client))
            return pesel;
        throw new Exception("The person is not a client");
    }

    public void setPesel(String pesel) throws Exception{
        if(personTypes.contains(PersonType.Client))
            this.pesel = pesel;
        else
            throw new Exception("The person is not a client");
    }

    public EnumSet<PersonType> getPersonTypes() {
        return personTypes;
    }

    private void setPersonTypes(EnumSet<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

}
