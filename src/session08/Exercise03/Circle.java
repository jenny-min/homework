package session08.Exercise03;

public class Circle implements Colorable{
    private double radius;
    private String color;

    //Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    //getter và setter
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
