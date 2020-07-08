package main.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Match {
    private LocalDate gameDate;
    private String location;
    private List<Player> playerList = new ArrayList<>();

    public Match(LocalDate gameDate, String location) {
        this.gameDate = gameDate;
        this.location = location;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addPlayer(Player player){
        if(!playerList.contains(player)){
            playerList.add(player);

            player.addMatch(this);
        }
    }

    @Override
    public String toString() {
        String info =  "Match{" +
                "gameDate=" + gameDate +
                ", location='" + location + '\'';
                for(Player player : playerList){
                    info += "\n\tPlayer: "+player.getFirstName()+" "+player.getLastName()+ ", "+player.getNumber();
                }
                return info + '}';
    }
}
