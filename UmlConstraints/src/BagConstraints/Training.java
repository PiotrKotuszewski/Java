package BagConstraints;

import java.util.ArrayList;
import java.util.List;

public class Training {
    private float trainingTime;
    private String trainingType;
    private List<PlayerTraining> playerTrainingList;

    public Training(float trainingTime, String trainingType) {
        this.trainingTime = trainingTime;
        this.trainingType = trainingType;
        this.playerTrainingList = new ArrayList<>();
    }

    public float getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(float trainingTime) {
        this.trainingTime = trainingTime;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public void addPlayerTraining(PlayerTraining playerTraining){
        if(!playerTrainingList.contains(playerTraining)){
            playerTrainingList.add(playerTraining);

            playerTraining.setTraining(this);
        }
    }

    @Override
    public String toString() {
        String info = "Training{" +
                "trainingTime=" + trainingTime +
                ", trainingType='" + trainingType + '\'';
        for(PlayerTraining playerTraining : playerTrainingList){
            info += "\n\t"+playerTraining.getTrainingDate();
        }
                return info + "\n}";
    }
}
