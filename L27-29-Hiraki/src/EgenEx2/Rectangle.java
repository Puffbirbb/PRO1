package EgenEx2;

public class Rectangle extends GeometriskeFigurer {
    private double sidelængdeH;
    private double sidelængdeB;

    public Rectangle(int x, int y, String name, double sidelængdeH, double sidelængdeB) {
        super(x, y, name);
        this.sidelængdeB = sidelængdeB;
        this.sidelængdeH = sidelængdeH;
    }

    @Override
    public double area() {
        return sidelængdeB * sidelængdeH;
    }
}
