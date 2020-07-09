package SubsetAndOrderedConstraints;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String position;

    private Set<Team> teamMembers; //asocjacja team - czlonek teamu
    private Set<Team> teamCapitan; //ograniczenie {subset} - asocjacja nadrzena to bycie czlonkiem teamu

    public Player(String firstName, String lastName, LocalDate birthDate, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.position = position;

        this.teamMembers = new HashSet<Team>();
        this.teamCapitan = new HashSet<Team>();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Team> getTeams() {
        return this.teamMembers;
    }


    private boolean findTeam(Team team) {
        if (team == null)
            return false;
        return this.teamMembers.contains(team);
    }

    public boolean addTeam(Team team) {
        if (!findTeam(team)) {
            this.teamMembers.add(team);
            team.addPlayer(this);
            return true;
        }
        return false;
    }

    private boolean findTeamCapitan(Team team) {
        if (team == null)
            return false;
        return this.teamCapitan.contains(team);
    }

    public void makeTeamCapitan(Team team) throws Exception {
        if (findTeam(team) && !findTeamCapitan(team)) {
            this.teamCapitan.add(team);
            team.setCapitan(this);
        } else
            throw new Exception("Pilkarz nie nalezy do druzyny");
    }

    public boolean removeAsCapitan(Team team) {
        if (findTeamCapitan(team)) {
            this.teamCapitan.remove(team);
            team.removeCapitan();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", position='" + position + '\'' +
                '}';
    }
}
