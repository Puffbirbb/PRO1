package Project1.craps;

public class CrapsApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Craps.");

        // TODO
        craps.CrapsGame game = new craps.CrapsGame();
        game.printRules();
        System.out.println();

        game.play();

        System.out.println("Thank you for playing craps.");
    }
}
