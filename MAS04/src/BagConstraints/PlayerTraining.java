package BagConstraints;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PlayerTraining {
    private LocalDate trainingDate;
    private Training training;
    private Player player;
    private static List<PlayerTraining> playerTrainingList = new ArrayList<>();

    public PlayerTraining(LocalDate trainingDate, Training training, Player player) {
        this.trainingDate = trainingDate;
        this.training = training;
        this.player = player;
        addPlayerTraining(this);
    }

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addPlayerTraining(PlayerTraining playerTraining){
        playerTrainingList.add(playerTraining);
    }

    public static Vector<PlayerTraining> getPlayerTraining(Player player){
        Vector<PlayerTraining> whoTrained = new Vector<PlayerTraining>();
        for(PlayerTraining pt : playerTrainingList){
            if(pt.getPlayer() == player)
                whoTrained.add(pt);
        }
        return whoTrained;
    }

    public static Vector<PlayerTraining> getPlayerTraining(Training training){
        Vector<PlayerTraining> trainingTrainer = new Vector<PlayerTraining>();
        for(PlayerTraining cg : playerTrainingList){
            if(cg.getTraining() == training)
                trainingTrainer.add(cg);
        }
        return trainingTrainer;
    }

    @Override
    public String toString() {
        return "PlayerTraining{" +
                "trainingDate=" + trainingDate +
                ", training=" + training +
                ", player=" + player +
                '}';
    }
}
