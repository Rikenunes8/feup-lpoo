package Shapes;

public class Ellipse implements AreaShape {
    private double x_radius;
    private double y_radius;

    public Ellipse(double x, double y) {
        x_radius = x;
        y_radius = y;
    }

    public double getX_radius() {
        return x_radius;
    }

    public double getY_radius() {
        return y_radius;
    }

    @Override
    public double getArea() {
        return Math.PI*x_radius*y_radius;
    }

    @Override
    public void draw() {
        System.out.println("Elipse");
    }
}
