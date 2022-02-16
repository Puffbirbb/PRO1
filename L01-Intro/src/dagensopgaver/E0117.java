package dagensopgaver;
import javax.swing.JOptionPane;

public class E0117 {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        System.out.print("Hello, ");
        System.out.print(name);
        System.out.println("!");
        String hal = JOptionPane.showInputDialog("My name is Hal! What would you like me to do?");
        System.out.print("Im sorry, ");
        System.out.print(name);
        System.out.println(". I'm afraid i can't do that.");
    }
}
