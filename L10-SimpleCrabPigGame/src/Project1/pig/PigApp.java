package Project1.pig;

public class PigApp {

        public static void main(String[] args) {
            System.out.println("Welcome to the PIG game (Get to 100 points)");

            // TODO
            PigGame game = new PigGame();
            game.printRules();
            System.out.println();

            game.play();

            System.out.println("Thank you for playing the game!");
        }
    }
