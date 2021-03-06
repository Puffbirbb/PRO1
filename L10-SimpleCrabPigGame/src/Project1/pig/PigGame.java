package Project1.pig;

import java.util.Random;
import java.util.Scanner;

public class PigGame {
    pig.Player player1 = new pig.Player("Player1");
    pig.Player player2 = new pig.Player("Player2");

    public void play(){
        Scanner scanner = new Scanner(System.in);
        pig.DiceThrower thrower = new pig.DiceThrower();
        Random generator = new Random();
        int goal = 100;
        int currentPoints = 0;

        boolean turn;
        boolean finished = false;


        if(generator.nextInt(2) == 0){
            turn = true;
        } else {
            turn = false;
        }

        while(!finished){

            if(turn){
                thrower.roll();
                System.out.println(player1.getPlayerName() + " Rolled " + thrower.sum());
                if(thrower.sum() > 1){
                    currentPoints += thrower.sum();
                    System.out.println("Current points: " + currentPoints);
                    if(currentPoints + player1.getPlayerPoints() >= goal){
                        printGameWon(player1.getPlayerName());
                        finished = true;
                    }

                } else {
                    currentPoints = 0;
                    turn = false;
                    printScore();
                }
            }
            if(!turn){
                thrower.roll();
                System.out.println(player2.getPlayerName() + " Rolled " + thrower.sum());
                if(thrower.sum() > 1){
                    currentPoints += thrower.sum();
                    System.out.println("Current points: " + currentPoints);
                    if(currentPoints + player2.getPlayerPoints() >= goal){
                        printGameWon(player2.getPlayerName());
                        finished = true;
                    }
                } else{
                    currentPoints = 0;
                    turn = true;
                    printScore();
                }
            }

            if(!finished){
                if(thrower.sum() > 1) {
                    System.out.println("Roll again? (Y/n) ");
                }
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("n")) {
                    if(turn){
                        player1.updatePlayerPoints(currentPoints);
                    } else {
                        player2.updatePlayerPoints(currentPoints);
                    }
                    turn = !turn;
                    currentPoints = 0;
                    printScore();
                }
            }
        }

        scanner.close();
    }

    /**
     * Prints a 'PlayerX have won' message.
     */
    public void printGameWon(String playerName) {
        System.out.println(playerName + " You are victorious!");
    }

    public void printScore(){
        System.out.println();
        System.out.println(player1.getPlayerName() + ": " + player1.getPlayerPoints());
        System.out.println(player2.getPlayerName() + ": " + player2.getPlayerPoints());
        System.out.println();

    }
    /**
     * Prints the rules of craps.
     */
    public void printRules(){

        System.out.println("-------------------------------------------------------------- Rules --------------------------------------------------------------");
        System.out.println("The game is played by two players. \n" +
                "The players take turns, throwing one die until he/she throws 1, \n" +
                "or until he/she decides to stop throwing. \n" +
                "The player accumulates points (the face value of the die on each throw, but if he/she throws 1, all points in this turn is lost. \n" +
                "If the player stops before throwing a 1, the points of this turn is added to the points of earlier turns. \n" +
                "The player that reaches 100 points after a turn, is the winner.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------- \n");
    }
}