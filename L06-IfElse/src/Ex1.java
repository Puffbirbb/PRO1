import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.print("How Old Are You? ");
        int age = in.nextInt();

        if(age < 0){
            System.out.println("You do not exist");
        }
        else if(age > 0) {
            System.out.println("You exist");
        }
        else {
            System.out.println("You have seen the light");
        }
        in.close();
    }
}
