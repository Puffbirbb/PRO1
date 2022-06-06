package EgenEx2;

public class Square extends GeometriskeFigurer {
    private double sidelængde;


    public Square(int x, int y, String name, double sidelængde) {
        super(x, y, name);
        this.sidelængde = sidelængde;
    }

    @Override
    public double area() {
        return Math.pow(sidelængde, 2.0);
    }
}
