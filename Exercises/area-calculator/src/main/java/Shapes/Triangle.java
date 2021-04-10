package Shapes;

public class Triangle implements AreaShape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return base*height/2;
    }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
