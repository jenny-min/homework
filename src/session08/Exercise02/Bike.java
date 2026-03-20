package session08.Exercise02;

public class Bike extends Vehicle {
    public Bike(String name, int speed) {
        super(name, speed);//Gọi constructor lớp cha Vehicle
    }

    //Ghi đè phương thức
    @Override
    public void displayInfo() {
        System.out.println("Bike Name: " + getName() + ", Speed: " + getSpeed());
    }
}
