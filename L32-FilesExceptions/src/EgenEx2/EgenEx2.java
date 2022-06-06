package EgenEx2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EgenEx2 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\gwion\\IdeaProjects\\PRO1\\PRO1\\L32-FilesExceptions\\src\\EgenEx1\\numbers.txt";
        File in = new File(fileName);
        ArrayList<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextDouble()) {
                double d = scanner.nextDouble();
                numbers.add((int) d);
                System.out.println(d);
                if (scanner.hasNextDouble())
                    scanner.nextLine();
            }
            System.out.println("\n");
            for (int i = numbers.size(); i != 0; i--) {
                System.out.println(numbers.get(i - 1));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

    }
}
