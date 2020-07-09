package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assistant")
public class Assistant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAssistant")
    private Long id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "employeeNr", nullable = false, unique = true)
    private int employeeNr;
    @Column(name = "qualifications", nullable = false)
    private String qualifi;

    public Assistant(String firstName, String lastName, int employeeNr, String qualifi) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNr = employeeNr;
        this.qualifi = qualifi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getEmployeeNr() {
        return employeeNr;
    }

    public void setEmployeeNr(int employeeNr) {
        this.employeeNr = employeeNr;
    }

    public String getQualifi() {
        return qualifi;
    }

    public void setQualifi(String qualifi) {
        this.qualifi = qualifi;
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeNr=" + employeeNr +
                ", qualifi='" + qualifi + '\'' +
                '}';
    }
}
