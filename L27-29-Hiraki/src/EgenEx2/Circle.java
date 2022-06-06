package EgenEx2;

public class Circle extends GeometriskeFigurer {
    private double radius;

    public Circle(int x, int y, String name, double radius) {
        super(x, y, name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radius, 2.0);
    }
}
