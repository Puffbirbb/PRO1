import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Number 1: ");
        int order1 = in.nextInt();
        System.out.print("Number 2: ");
        int order2 = in.nextInt();
        System.out.print("Number 3: ");
        int order3 = in.nextInt();

        if (order1 < order2 && order2 < order3) {
            System.out.println("In Increasing Order");
        }
        else if (order1 > order2 && order2 > order3) {
            System.out.println("In Decreasing Order");
        }
        else {
            System.out.println("This is wrong");
        }
    }
}
