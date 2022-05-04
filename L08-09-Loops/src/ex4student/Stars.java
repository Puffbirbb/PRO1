package ex4student;

public class Stars
{
    public void starExA(int rowCount)
    {
        System.out.println("A");
        for (int row = 1; row <= rowCount; row++) {

            System.out.printf("%2d: ", row);
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;

            //row 1
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("B");
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = rowCount - row;
            int dashCount = rowCount - starCount;

            //row 2
            for (int i = 1; i <= starCount; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("C");
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;

            //row 3
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //row 4
        System.out.println("D");
        for (int row = 1; row <= rowCount/2; row++) {
            System.out.printf("%2d: ", row);
            int starCount = row * 2 - 1;
            int dashCount = rowCount / 2 - row;

            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int row = rowCount/2; row > 0; row--) {
            System.out.printf("%2d: ", row);
            int starCount = row * 2 - 1;
            int dashCount = rowCount / 2 - row;

            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}