package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "treatment")
public class Treatment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treatment")
    private Long id;
    @Column(name = "used_materials_count", unique = true)
    private int usedMaterialsCount;
    @Column(name = "tool_wear", unique = true)
    private String toolWear;
    @Column(name = "radiation_time", unique = true)
    private double radiationTime;
    @ManyToOne
    @JoinColumn(name = "visit_id")
    private Visit visit;

    Treatment(){}

    public Treatment(int usedMaterialsCount, String toolWear, double radiationTime) {
        this.usedMaterialsCount = usedMaterialsCount;
        this.toolWear = toolWear;
        this.radiationTime = radiationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUsedMaterialsCount() {
        return usedMaterialsCount;
    }

    public void setUsedMaterialsCount(int usedMaterialsCount) {
        this.usedMaterialsCount = usedMaterialsCount;
    }

    public String getToolWear() {
        return toolWear;
    }

    public void setToolWear(String toolWear) {
        this.toolWear = toolWear;
    }

    public double getRadiationTime() {
        return radiationTime;
    }

    public void setRadiationTime(double radiationTime) {
        this.radiationTime = radiationTime;
    }

    public void updateToothCondition(String toothName){

    }
}
