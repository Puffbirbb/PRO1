package EgenEx3;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Chili[] chillis = new Chili[]{
                new Chili("Aji chili", 5_000),
                new Chili("Aji Cito", 80_000),
                new Chili("Carolina Reaper", 2_000_000),
                new Chili("Ghost Pepper", 855_000)
        };

        Beer[] beers = new Beer[]{
                new Beer("Tuborg Classic", 5.2),
                new Beer("Grøn Pilsner", 4.5),
                new Beer("Guld Elephant", 9.8),
                new Beer("Royal Free", 0.2)
        };

        Chili maxC = (Chili) max(chillis);
        System.out.print("The Strongest Owned ");
        System.out.println(maxC);
        System.out.print("Average Scoville of All Chillis: ");
        System.out.println(average(chillis));

        System.out.println(Arrays.toString(blackFridayMeal(chillis, beers)));
    }
    public static double average(Measurable[] objects){
        double sum = 0;
        for (Measurable obj : objects){
            sum = sum + obj.getMeasure();
        }
        if (objects.length > 0) {
            return sum / objects.length;
        }
        else {
            return 0;
        }
    }
    public static Measurable max(Measurable[] objects){
        Measurable m = objects[0];
        for (Measurable obj : objects){
            if (obj.getMeasure() > m.getMeasure()){
                m = obj;
            }
        }
        return m;
    }
    public static Measurable[] blackFridayMeal(Measurable[] chillis, Measurable[] beers){
        Measurable[] bfMeal = new Measurable[2];
        bfMeal[0] = max(chillis);
        bfMeal[1] = max(beers);
        return bfMeal;
    }
}