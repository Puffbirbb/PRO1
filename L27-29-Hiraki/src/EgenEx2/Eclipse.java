package EgenEx2;

public class Eclipse extends GeometriskeFigurer {
    private double radiusL;
    private double radiusS;

    public Eclipse(int x, int y, String name, double radiusL, double radiusS) {
        super(x, y, name);
        this.radiusL = radiusL;
        this.radiusS = radiusS;
    }

    @Override
    public double area() {
        return Math.PI*radiusL*radiusS;
    }
}
