package session08.Exercise02;

public abstract class Vehicle {
    private String name;
    private int speed;

    //Constructor
    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    //getter name và speed
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    //Phương thức trừu tượng displayInfo()
    public abstract void displayInfo();

    //Phương thức start() "Vehicle is starting..."
    public void start() {
        System.out.println("Vehicle is starting...");
    }
}
