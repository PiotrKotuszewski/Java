package main.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private LocalDate startDate;
    private LocalDate endTime;
    private float prize;
    private List<Team> teams = new ArrayList<>();

    public Tournament(LocalDate startDate, LocalDate endTime, float prize) {
        this.startDate = startDate;
        this.endTime = endTime;
        this.prize = prize;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public void addTeam(Team team){
        if(!teams.contains(team)){
            teams.add(team);

            team.addTournament(this);
        }
    }

    @Override
    public String toString() {
        String info = "Tournament{" +
                "startDate=" + startDate +
                ", endTime=" + endTime +
                ", prize=" + prize;
        for(Team team : teams){
            info+="\n\t"+team.getTeamName();
        }
        return info+'}';
    }
}
