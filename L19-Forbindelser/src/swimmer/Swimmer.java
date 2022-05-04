package swimmer;

import java.util.ArrayList;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    public Swimmer(String name, ArrayList<Double> lapTimes, TrainingPlan trainingPlan) {
        this.name = name;
        this.lapTimes = lapTimes;
        this.trainingPlan = trainingPlan;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        double bestLapTime = 2;
        for (int i = 0; i < getLapTimes().size(); i++) {
            if (getLapTimes().get(i) < bestLapTime) {
                bestLapTime = getLapTimes().get(i);
            }
        }
        return bestLapTime;
    }

    public TrainingPlan getTrainingPlan(){
        return trainingPlan;
    }
    public TrainingPlan setTrainingPlan(TrainingPlan trainingPlan){
        this.trainingPlan = trainingPlan;
        return trainingPlan;
    }
    public TrainingPlan removeTrainingPlan() {
        this.trainingPlan = null;
        return null;
    }

}
