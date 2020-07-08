package main.Model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Tournament> tournaments = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addTournament(Tournament tournament){
        if(!tournaments.contains(tournament)) {
            tournaments.add(tournament);

            tournament.addTeam(this);
        }
    }
    @Override
    public String toString() {
        String info =  "Team{" +
                "teamName='" + teamName + '\'';
        for(Tournament tournament : tournaments){
            info+="\n\t"+tournament.getStartDate()+", "+tournament.getEndTime()+", "+tournament.getPrize();
        }
                return info+'}';
    }
}
