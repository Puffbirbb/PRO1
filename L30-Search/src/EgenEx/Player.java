package EgenEx;

public class Player {
    private final String name;
    private final int height;
    private final int weight;
    private final int scoredGoals;


    public Player(String name, int height, int weight, int scoredGoals) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.scoredGoals = scoredGoals;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public String toString() {
        return "\nName: " + name +
                "\nHeight: " + height +
                "\nWeight: " + weight +
                "\nScored Goals: " + scoredGoals;
    }
}
