package Shapes;

public class Rectangle implements AreaShape {
    private double height;
    private double width;

    public Rectangle(double x, double y) {
        this.width = x;
        this.height = y;
    }

    @Override
    public double getArea() {
        return this.width*this.height;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
