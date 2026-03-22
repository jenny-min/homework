package session08.Exercise09;

import java.util.ArrayList;

class Garage {
    private ArrayList<Car> cars = new ArrayList<>();

    //Thêm xe vào gara
    public void addCar(Car car) {
        cars.add(car);
    }

    //Khởi động tất cả xe
    public void startAll() {
        for (Car car : cars) {
            System.out.println(car.start());
        }
    }

    //Dừng tất cả xe
    public void stopAll() {
        for (Car car : cars) {
            System.out.println(car.stop());
        }
    }

    //Thực hiện nạp nhiên liệu cho xe
    public void refuelAll() {
        for (Car car : cars) {
            if (car instanceof Refuelable r) {
                r.refuel();
            }
        }
    }
}
