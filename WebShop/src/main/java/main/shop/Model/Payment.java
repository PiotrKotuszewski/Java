package main.shop.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long id;
    @Column(name = "payment_type", nullable = false)
    private String paymantType;
    @Column(name = "allowed", nullable = false)
    private boolean allowed;

    public Payment(){}

    public Payment(String paymantType, boolean allowed) {
        this.paymantType = paymantType;
        this.allowed = allowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymantType() {
        return paymantType;
    }

    public void setPaymantType(String paymantType) {
        this.paymantType = paymantType;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymantType='" + paymantType + '\'' +
                ", allowed=" + allowed +
                '}';
    }
}
