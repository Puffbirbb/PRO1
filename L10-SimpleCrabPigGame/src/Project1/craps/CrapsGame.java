package Project1.craps;

import Project1.craps.DiceThrower;
import java.util.Scanner;

public class CrapsGame {

    /**
     * Simulates playing one game of craps.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();
        int firstRole = 0;

        boolean finished = false;
        while (!finished){
            if (thrower.getRollCount() == 0){
                thrower.roll();
                System.out.println(thrower.rollDescription());
                if (thrower.sum() == 7 || thrower.sum() == 11){
                    printGameWon();
                    finished = true;
                }
                else if (thrower.sum() == 2 || thrower.sum() == 3 || thrower.sum() == 12){
                    printGameLost();
                    finished = true;
                }
            }
            else if (thrower.getRollCount() >= 1) {
                if (thrower.getRollCount() == 1){
                    firstRole = thrower.sum();
                }
                System.out.println("Roll Again!");
                String answer = scanner.nextLine();
                thrower.roll();
                System.out.println(thrower.rollDescription());
                if (thrower.sum() == 7){
                    printGameLost();
                    finished = true;
                }
                else if (thrower.sum() == firstRole){
                    printGameWon();
                    finished = true;
                }
            }
        }
        scanner.close();
    }

    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        System.out.println("Congratulations, You've WON!");
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        System.out.println("You Lost, Give UP!");
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules() {
        System.out.println("===========================================================");
        System.out.println("If Your First Roll Sum is a 7 or an 11 you've won");
        System.out.println("If Your First Roll Sum is a 2, 3 or an 12 you've lost");
        System.out.println("If Your First Roll is all other values, you roll again");
        System.out.println("If Your Roll Sum is 7 or 11 after First Roll, you've lost");
        System.out.println("If Your New Roll Sum after first roll is equal to, ");
        System.out.println("First Roll Sum of all other values.");
        System.out.println("If New Roll Sum is 7, you've lost.");
        System.out.println("===========================================================");
    }
}