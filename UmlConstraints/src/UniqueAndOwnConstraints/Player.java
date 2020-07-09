package UniqueAndOwnConstraints;

import Exceptions.NotUniqueValueException;
import Exceptions.WrongFormatException;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String firstName;
    private String lastName;
    private String position;
    private int shirtNumber;
    private static final Set<Integer> numbers = new HashSet<>();

    public Player(String firstName, String lastName, String position, int shirtNumber) {
        if(!firstName.matches("\\b[A-Z][a-z]{2,15}"))
            throw new WrongFormatException("Imie musi zaczynac sie od wielkiej litery i miec conajmniej 3 litery");
        else if(!lastName.matches("\\b[A-Z][a-z]{5,20}"))
            throw new WrongFormatException("Nazwisko musi zaczynac sie od wielkiej litery i miec conajmniej 6 litery");
        else if(isNumberUnique(shirtNumber))
            throw new NotUniqueValueException(String.format("Numer %s jest zajety", shirtNumber));
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.shirtNumber = shirtNumber;
        numbers.add(shirtNumber);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(!firstName.matches("\\b[A-Z][a-z]{2,15}"))
            throw new WrongFormatException("Imie musi zaczynac sie od wielkiej litery i miec conajmniej 3 litery");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!lastName.matches("\\b[A-Z][a-z]{5,15}"))
            throw new WrongFormatException("Nazwisko musi zaczynac sie od wielkiej litery i miec conajmniej 6 litery");
        this.lastName = lastName;
    }

    public static Set<Integer> getNumbers() {
        return numbers;
    }

    public void setShirtNumber(int shirtNumber) {
        if(isNumberUnique((shirtNumber)))
            throw new NotUniqueValueException(String.format("Numer %s jest zajety", shirtNumber));

        numbers.remove(this.shirtNumber);
        numbers.add(shirtNumber);
        this.shirtNumber = shirtNumber;

    }

    private boolean isNumberUnique(int shirtNumber){
        return numbers.contains(shirtNumber);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", shirtNumber=" + shirtNumber +
                '}';
    }
}
