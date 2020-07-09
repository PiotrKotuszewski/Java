package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "dentist")

public class Dentist extends Person implements Serializable {

    private Long id;
    private String benefits;
    private int dyplomsCount;

    private List<Duty> duties = new ArrayList<>();

    public Dentist(){}

    public Dentist(String firstName, String lastName, LocalDate birthDate, String benefits, int dyplomsCount) {
        super(firstName, lastName, birthDate);
        this.benefits = benefits;
        this.dyplomsCount = dyplomsCount;
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
    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @Basic
    public int getDyplomsCount() {
        return dyplomsCount;
    }

    public void setDyplomsCount(int dyplomsCount) {
        this.dyplomsCount = dyplomsCount;
    }


    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    public List<Duty> getDuties() {
        return duties;
    }

    public void setDuties(List<Duty> duties) {
        this.duties = duties;
    }

    public void addDuty(Duty duty){
        getDuties().add(duty);
        duty.setDentist(this);
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", benefits='" + benefits + '\'' +
                ", dyplomsCount=" + dyplomsCount +
                '}';
    }
}
