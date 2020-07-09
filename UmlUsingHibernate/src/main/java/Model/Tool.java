package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tool")
public class Tool implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTool")
    private Long id;
    @Column(name = "tool_name", nullable = false)
    private String toolName;
    @Column(name = "sterilization_time", nullable = false)
    private double sterilizationTime;
    @Column(name = "steaming_time", nullable = false)
    private double steamingTime;

    Tool(){}

    public Tool(String toolName, double sterilizationTime, double steamingTime) {
        this.toolName = toolName;
        this.sterilizationTime = sterilizationTime;
        this.steamingTime = steamingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public double getSterilizationTime() {
        return sterilizationTime;
    }

    public void setSterilizationTime(double sterilizationTime) {
        this.sterilizationTime = sterilizationTime;
    }

    public double getSteamingTime() {
        return steamingTime;
    }

    public void setSteamingTime(double steamingTime) {
        this.steamingTime = steamingTime;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", toolName='" + toolName + '\'' +
                ", sterilizationTime=" + sterilizationTime +
                ", steamingTime=" + steamingTime +
                '}';
    }
}
