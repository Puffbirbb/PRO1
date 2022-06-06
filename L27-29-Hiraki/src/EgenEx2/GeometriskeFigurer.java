package EgenEx2;

public abstract class GeometriskeFigurer {
    private String name;
    private int x, y;

    public GeometriskeFigurer(int x,int y,String name){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public void setX(int dX) {
        x += dX;
    }

    public void setY(int dY) {
        y += dY;
    }

    public String position() {
        return name + ": " + "x: " + x + "y: " + y;
    }
}
