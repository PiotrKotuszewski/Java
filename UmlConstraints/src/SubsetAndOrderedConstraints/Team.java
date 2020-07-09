package SubsetAndOrderedConstraints;

import Exceptions.NotUniqueValueException;

import java.util.*;

public class Team {
    private String teamName;
    private List<Player> members;
    private Player capitan;
    private static Map<String, Team> teams = new HashMap<>();

    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
        this.capitan = null;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) throws NotUniqueValueException {
        if(findTeam(teamName))
            throw new NotUniqueValueException("Istnieje zespol o takiej nazwie");
        this.teamName = teamName;
    }

    public Player getCapitan() {
        return capitan;
    }

    public List<Player> getMembers() {
        return members;
    }

    public void setCapitan(Player capitan)throws Exception {
        if(capitan == null)
            removeCapitan();
        else if(this.capitan == capitan)
            return;
        else if(findPlayer(capitan)){
            if(this.capitan != null)
                this.capitan.removeAsCapitan(this);
            this.capitan = capitan;
            capitan.makeTeamCapitan(this);
        }else
            throw new Exception("Pilkarz nie nalezy do druzyny");
    }

    public void removeCapitan(){
        this.capitan = null;
    }

    public boolean addPlayer(Player player){
        if(!findPlayer(player)){
            this.members.add(player);
            player.addTeam(this);
            return true;
        }
        return false;
    }

    public static void addTeam(Team team){
        teams.put(team.teamName, team);
    }

    //Obsluga asocjacji team-player
    private boolean findPlayer(Player player){
        return this.members.contains(player);
    }

    private static boolean findTeam(Team team){
        return teams.containsValue(team);
    }
    private static boolean findTeam(String name){
        return teams.containsKey(name);
    }


    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", members=" + members+
                ", capitan=" + capitan+
                '}';
    }
}
