package main.Model;

import java.time.LocalDate;

public class ClientVisit {
    private LocalDate visitDate;
    private Client client;
    private Visit visit;

    public ClientVisit(LocalDate visitDate, Client client, Visit visit) {
        this.visitDate = visitDate;
        this.client = client;
        this.visit = visit;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    @Override
    public String toString() {
        return "ClientVisit{" +
                "visitDate=" + visitDate +
                ", Client name= " + client.getFirstName() +
                ", Client lastname= " + client.getLastName() +
                ", Client pesel= " + client.getPesel() +
                ", Visit start at= " + visit.getStartTime() +
                ", Visit cost= " + visit.getVisitCost() + '}'+"\n";
    }
}
