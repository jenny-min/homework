package session08.Exercise03;

public class Square implements Colorable{
    private double side;
    private String color;

    //constructor

    public Square(double side) {
        this.side = side;
    }

    //getter
    public double getSide() {
        return side;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
