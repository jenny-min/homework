package session08.Exercise09;

public class Main {
    public static void main(String[] args) {
        //Khởi tạo biến
        Garage garage = new Garage();

        //Tạo 2 đối tượng car
        Car eCar = new ElectricCar("Telsa", 2023, 40000);
        Car gCar = new GasCar("Toyota", 2022, 30000);

        //Thêm xe vào garage
        garage.addCar(eCar);
        garage.addCar(gCar);

        //Khởi động
        System.out.println("---START---");
        garage.startAll();

        //Dừng
        System.out.println("\n---STOP---");
        garage.stopAll();

        //Nạp năng lượng
        System.out.println("\n---REFUEL---");
        garage.refuelAll();
    }
}
