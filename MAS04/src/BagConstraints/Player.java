package BagConstraints;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int shirtNumber;
    private String position;
    private List<PlayerTraining> playerTrainingList;

    public Player(int shirtNumber, String position) {
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.playerTrainingList = new ArrayList<>();
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void addPlayerTraining(PlayerTraining playerTraining){
        if(!playerTrainingList.contains(playerTraining)){
            playerTrainingList.add(playerTraining);

            playerTraining.setPlayer(this);
        }
    }

    @Override
    public String toString() {
        String info =  "Player{" +
                "shirtNumber=" + shirtNumber +
                ", position='" + position + '\'';
        for(PlayerTraining playerTraining : playerTrainingList){
            info += "\n\t"+playerTraining.getTrainingDate();
        }
        return info + "\n}";
    }
}
