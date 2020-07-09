package Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tooth")
public class Tooth implements Serializable {

    private Long toothId;
    private String toothCondition;
    private String toothColor;
    private int toothName;
    private Client client;

    public Tooth(){}

    public Tooth(String toothCondition, String toothColor, int toothName) {
        this.toothCondition = toothCondition;
        this.toothColor = toothColor;
        this.toothName = toothName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getToothId() {
        return toothId;
    }

    public void setToothId(Long toothId) {
        this.toothId = toothId;
    }

    @Basic
    public String getToothCondition() {
        return toothCondition;
    }

    public void setToothCondition(String toothCondition) {
        this.toothCondition = toothCondition;
    }

    @Basic
    public String getToothColor() {
        return toothColor;
    }

    public void setToothColor(String toothColor) {
        this.toothColor = toothColor;
    }

    @Basic
    public int getToothCount() {
        return toothName;
    }

    public void setToothCount(int toothName) {
        this.toothName = toothName;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Tooth{" +
                "toothId=" + toothId +
                ", toothCondition='" + toothCondition + '\'' +
                ", toothColor='" + toothColor + '\'' +
                ", toothName=" + toothName +
                '}';
    }
}
