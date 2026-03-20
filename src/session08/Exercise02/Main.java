package session08.Exercise02;

public class Main {
    public static void main(String[] args) {
        //Khởi tạo đối tượng
        Vehicle car = new Car("Toyota", 120);
        Vehicle bike = new Bike("Yamaha", 80);

        //Gọi phương thức
        car.start();
        car.displayInfo();

        bike.start();
        bike.displayInfo();
    }
}
