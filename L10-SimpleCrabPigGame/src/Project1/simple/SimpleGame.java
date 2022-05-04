package simple;

import java.util.Scanner;

public class SimpleGame {

    /**
     * Simulates playing one game of Simple.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        simple.DiceThrower thrower = new simple.DiceThrower();

        boolean finished = false;
        while (!finished) {
            thrower.roll();
            System.out.println(thrower.rollDescription());
            System.out.println("Roll again? (Y/n) ");
            String answer = scanner.nextLine();
            System.out.println();
            if (answer.equalsIgnoreCase("n")) {
                finished = true;
            }
        }
        scanner.close();

        System.out.printf("\nResults:\n");
        System.out.printf("---------\n");
        System.out.println("Roll Count: " + thrower.getRollCount());
        System.out.println("Total Face Value: " + thrower.getTotalFaceValue());
        System.out.println("Total 6 Count: " + thrower.getFaceValueSix());
        System.out.println("Total Same Faces: " + thrower.getSameFace());
        System.out.println("Max Sum In One Roll: " + thrower.getMaxFaceSum());
        System.out.printf("Average Sum: " + "%.1f", thrower.getAverageSum());
        System.out.println();
    }

    /**
     * Prints the rules of Simple.
     */
    public void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Simple:");
        System.out.println("The player throws the 2 dice as long as he/she wants.");
        System.out.println("=====================================================");
    }
}
