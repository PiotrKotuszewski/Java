package main.Model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Duty {

    private LocalDate dutyDate;
    private List<Dentist> dentistList = new ArrayList<>();

    public Duty(LocalDate dutyDate) {
        this.dutyDate = dutyDate;
    }

    public LocalDate getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(LocalDate dutyDate) {
        this.dutyDate = dutyDate;
    }

    public void addDentist(Dentist dentist){
        if(!dentistList.contains(dentist)){
            dentistList.add(dentist);

            dentist.addDuty(this);
        }
    }

    @Override
    public String toString() {
        String info = "Duty{" +
                "dutyDate=" + dutyDate;
        for(Dentist dentist : dentistList) {
            info += "\n\t Dentis firstName="+dentist.getFirstName()+
                    ", Dentis lastName="+dentist.getLastName()+
                    ", Dentist pesel="+dentist.getPesel();
        }
                return info + "\n}";
    }
}
