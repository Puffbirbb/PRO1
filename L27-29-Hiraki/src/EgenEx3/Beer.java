package EgenEx3;

public class Beer implements Measurable{
    public String name;
    public double alcoholPercent;

    public Beer (String name, double alcoholPercent){
        this.name = name;
        this.alcoholPercent = alcoholPercent;
    }

    public double getMeasure(){
        return alcoholPercent;
    }

    public String toString(){
        return "\nBeer: " + name + "\nAlcohol Percentage: " + alcoholPercent;
    }
}
