package EgenEx2;

public class GFtest {
    public static void main(String[] args) {
        Square sq1 = new Square(10, 10, "Square", 10);
        System.out.println("Area of Square: " + sq1.area());

        Circle c1 = new Circle(5, 5, "Circle",10);
        System.out.println("Area of Circle: " + c1.area());

        Eclipse e1 = new Eclipse(20, 20, "Eclipse", 10,5);
        System.out.println("Area of Eclipse: " + e1.area());

        Rectangle r1 = new Rectangle(15, 15, "Rectangle", 10, 5);
        System.out.println("Area of Rectangle: " + r1.area());

    }
}
