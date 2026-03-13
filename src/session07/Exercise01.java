package session07;

public class Exercise01 {
    //Phương thức main
    public static void main(String[] args) {
        //Tạo Rectangle với constructor mặc định
        Rectangle rectangle1 = new Rectangle();
        System.out.println("Hình chữ nhật 1:");
        rectangle1.display();

        //Tạo Rectangle với constructor có tham số
        Rectangle rectangle2 = new Rectangle(5.0, 3.0);
        System.out.println("\nHình chữ nhật 2:");
        rectangle2.display();
    }

    //Lớp Rectangle
    public static class Rectangle {
        //Thuộc tính
        private double length;
        private double width;

        //Constructor mặc định
        public Rectangle() {
            this.length = 1.0;
            this.width = 1.0;
        }

        //Constructor có tham số
        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        //Phương thức tính diện tích
        public double getArea() {
            return length * width;
        }

        //Phương thức tính chu vi
        public double getPerimeter() {
            return 2 * (length + width);
        }

        //Phương thức hiển thị
        public void display() {
            System.out.println("Chiều dài: " + length);
            System.out.println("Chiều rộng: " + width);
            System.out.println("Diện tích: " + getArea());
            System.out.println("Chu vi: " + getPerimeter());
        }
    }
}
