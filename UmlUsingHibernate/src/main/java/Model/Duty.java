package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "duty")
public class Duty implements Serializable {

    private Long id;
    private LocalDate dutyDate;
    private double dutyTime;
    private int acceptedClientsCount;
    private double bonus;
    private Dentist dentist;

    public Duty(){}

    public Duty(LocalDate dutyDate, double dutyTime, int acceptedClientsCount) {
        this.dutyDate = dutyDate;
        this.dutyTime = dutyTime;
        this.acceptedClientsCount = acceptedClientsCount;
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
    public LocalDate getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(LocalDate dutyDate) {
        this.dutyDate = dutyDate;
    }

    @Basic
    public double getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(double dutyTime) {
        this.dutyTime = dutyTime;
    }

    @Basic
    public int getAcceptedClientsCount() {
        return acceptedClientsCount;
    }

    public void setAcceptedClientsCount(int acceptedClientsCount) {
        this.acceptedClientsCount = acceptedClientsCount;
    }

    public Double calculateBonus(double dutyTime){
        double bonus;
        if(dutyTime > 6.0)
            bonus = (dutyTime-6)*30;
        else
            bonus = 0;
        return bonus;
    }

    public Double calculateBonus(int clientCount){
        double bonus;
        if(clientCount > 12)
            bonus = (clientCount-10)*40;
        else
            bonus = 0;
        return bonus;
    }

    @ManyToOne
    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    @Override
    public String toString() {
        return "Duty{" +
                "id=" + id +
                ", dutyDate=" + dutyDate +
                ", dutyTime=" + dutyTime +
                ", acceptedClientsCount=" + acceptedClientsCount +
                ", dentist_id=" + dentist.getId()+
                '}';
    }
}