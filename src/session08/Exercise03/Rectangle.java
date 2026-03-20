package session08.Exercise03;

public class Rectangle implements Colorable{
    private double width;
    private double lenght;
    private String color;

    //constructor
    public Rectangle(double width, double lenght) {
        this.width = width;
        this.lenght = lenght;
        this.color = color;
    }

    //getter
    public double getWidth() {
        return width;
    }

    public double getLenght() {
        return lenght;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
