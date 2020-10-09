package main.shop.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "details")
public class Details implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_details")
    private Long id;
    private double rate;

    public Details(){}

    public Details(double rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", rate=" + rate +
                '}';
    }
}
