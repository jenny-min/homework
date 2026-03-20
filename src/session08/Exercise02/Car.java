package session08.Exercise02;

public class Car extends Vehicle {
    public Car(String name, int speed) {
        super(name, speed);//Gọi constructor lớp cha Vehicle
    }

    //Ghi đè phương thức
    @Override
    public void displayInfo() {
        System.out.println("Car Name: " + getName() + ", Speed: " + getSpeed() + "km/h");
    }
}
