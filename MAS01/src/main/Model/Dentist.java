package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dentist implements Serializable {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String pesel;
    private List<String> dyploms;
    private Map<LocalDate, Duty> dutiesQualif = new TreeMap<>();
    private List<Duty> duties = new ArrayList<>();

    public Dentist(String firstName, String lastName, LocalDate birthDate, String pesel, List<String> dyploms) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.dyploms = dyploms;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public List<String> getDyploms() {
        return dyploms;
    }

    public void setDyploms(List<String> dyploms) {
        this.dyploms = dyploms;
    }

    public void addDuty(Duty duty) {
        if (!duties.contains(duty)) {
            duties.add(duty);

            duty.addDentist(this);
        }
    }
    public void addDutiesQualif(Duty duty){
        if(!dutiesQualif.containsKey(duty.getDutyDate())){
            dutiesQualif.put(duty.getDutyDate(), duty);

            duty.addDentist(this);
        }
    }

    public Duty findDutyQualif(LocalDate date) throws Exception{
        if(!dutiesQualif.containsKey(date))
            throw new Exception("The dentist is not on duty that day: "+date);

        return dutiesQualif.get(date);
    }

    @Override
    public String toString() {
        String info =("Dentist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", pesel='" + pesel + '\'' +
                ", dyploms=" + dyploms);
        for(Duty duty : duties){
            info += "\n\tdutyDate=" + duty.getDutyDate();
        }
                return info + "\n}";
    }
}
