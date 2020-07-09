package main.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Player{
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int number;
    private String position;
    private List<Match> matchList = new ArrayList<>();

    public Player(String firstName, String lastName, LocalDate birthDate, int number, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.number = number;
        this.position = position;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void addMatch(Match match){
        if(!matchList.contains(match)){
            matchList.add(match);

            match.addPlayer(this);
        }
    }

    @Override
    public String toString() {
        String info =  "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", number=" + number +
                ", position='" + position + '\'';
        for(Match match : matchList){
            info+= "\n\tMatches: "+match.getGameDate()+", "+match.getLocation();
        }
                return info + '}';
    }
}
