package EgenEx3;

public class Chili implements Measurable {
    public String name;
    public double scoville;

    public Chili (String name, int scoville){
        this.name = name;
        this.scoville = scoville;
    }

    public double getMeasure(){
        return scoville;
    }

    public String toString(){
        return "Chili: " +  name + "\nScoville of Chili: " + scoville;
    }
}
