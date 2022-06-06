package DemoFiles.readnumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumbersApp {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\gwion\\IdeaProjects\\PRO1\\PRO1\\L32-FilesExceptions\\src\\EgenEx1\\numbers.txt";
		File in = new File(fileName);
		try (Scanner scanner = new Scanner(in)) {
			double sum = 0;
			while (scanner.hasNextDouble()) {
				double d = scanner.nextDouble();
				System.out.println(d);
				sum += d;
				if (!scanner.hasNextDouble()) {
					scanner.nextLine();
				}
			}

			System.out.println("Sum is " + sum);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
	}
}
