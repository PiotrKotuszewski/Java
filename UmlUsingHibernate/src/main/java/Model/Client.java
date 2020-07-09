package Model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "client")

public class Client extends Person implements Serializable {

    private Long id;
    private String pesel;
    private String phoneNumber;
    private List<Tooth> tooths = new ArrayList<>();

  //  private List<Visit> visits = new ArrayList<>();

    public Client(){}

    public Client(String firstName, String lastName, LocalDate birthDate, String pesel, String phoneNumber) {
        super(firstName, lastName, birthDate);
        this.phoneNumber = phoneNumber;
        this.pesel = pesel;
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
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public List<Tooth> getTooths() {
        return tooths;
    }

    public void setTooths(List<Tooth> tooths) {
        this.tooths = tooths;
    }

  /*  @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(name = "client_visit",
            joinColumns = {@JoinColumn(name = "id_client")},
            inverseJoinColumns = {@JoinColumn(name = "id_visit")})
    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }*/

    public void addTooth(Tooth tooth){
        getTooths().add(tooth);
        tooth.setClient(this);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", pesel='" + pesel + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tooths=" + tooths +
                '}';
    }
}

