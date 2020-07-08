package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable{

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String pesel;
    private String phoneNumber;
    private List<ClientVisit> clientVisits;

    public Client(String firstName, String lastName, LocalDate birthDate, String pesel, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.clientVisits = new ArrayList<>();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ClientVisit> getClientVisits() {
        return clientVisits;
    }

    public void addClientVisit(ClientVisit clientVisit){
        if(!clientVisits.contains(clientVisit)){
            clientVisits.add(clientVisit);
            clientVisit.setClient(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder()
                .append("Client{").append("firstName=").append(firstName)
                .append(", lastName=").append(lastName)
                .append(", birthDate=").append(birthDate)
                .append(", pesel=").append(pesel)
                .append(", phoneNumber=").append(phoneNumber);

        for(ClientVisit clientVisit : clientVisits){
            info.append("\n\tvisitDate=").append(clientVisit.getVisitDate());
        }

        return info+ " }";
    }
}
