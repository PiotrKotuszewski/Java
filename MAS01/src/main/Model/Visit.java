package main.Model;

import java.util.ArrayList;
import java.util.List;

public class Visit {
    private String startTime;
    private String endTime;
    private double visitCost;
    private List<ClientVisit> clientVisits;

    public Visit(double visitCost, String startTime, String endTime) {
        this.visitCost = visitCost;
        this.startTime = startTime;
        this.endTime = endTime;
        this.clientVisits = new ArrayList<>();
    }

    public double getVisitCost () {
        return visitCost;
    }

    public void setVisitCost(double visitCost) {
        this.visitCost = visitCost;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void addClientVisit(ClientVisit clientVisit){
        if(!clientVisits.contains(clientVisit)){
            clientVisits.add(clientVisit);
            clientVisit.setVisit(this);
        }
    }

    public List<ClientVisit> getClientVisits() {
        return clientVisits;
    }

    @Override
    public String toString() {
        StringBuilder info =  new StringBuilder().
                append("Visit{")
                .append("visitCost=")
                .append(visitCost)
                .append(", startTime=")
                .append(startTime)
                .append(", endTime=")
                .append(endTime);

        for(ClientVisit clientVisit : clientVisits) {
            info.append("\n\tdutyTime=").append(clientVisit.getVisitDate());
        }

        return info + " }";
    }
}
