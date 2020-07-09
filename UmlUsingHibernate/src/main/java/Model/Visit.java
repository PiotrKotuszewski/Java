package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "visit")
public class Visit implements Serializable {

    private Long id;
    private LocalDate visitDate;
    private double visitStart;
    private double visitEnd;
    private double visitCost;
    private boolean isNew;
    private List<Client> clients = new ArrayList<>();
    //Atrybut powtarzalny
    //@OneToMany(mappedBy = "visit")
   // private List<Treatment> treatments;

    public Visit(){}

    public Visit(LocalDate visitDate, double visitStart, double visitEnd, double visitCost, boolean isNew) {
        this.visitDate = visitDate;
        this.visitStart = visitStart;
        this.visitEnd = visitEnd;
        this.visitCost = visitCost;
        this.isNew = isNew;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Basic
    public double getVisitStart() {
        return visitStart;
    }

    public void setVisitStart(double visitStart) {
        this.visitStart = visitStart;
    }

    @Basic
    public double getVisitEnd() {
        return visitEnd;
    }

    public void setVisitEnd(double visitEnd) {
        this.visitEnd = visitEnd;
    }

    @Basic
    public double getVisitCost() {
        return visitCost;
    }

    public void setVisitCost(double visitCost) {
        this.visitCost = visitCost;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

 /*   @ElementCollection
    @ManyToMany(mappedBy = "visits")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client){
        this.clients.add(client);
        client.getVisits().add(this);
    }*/
}
