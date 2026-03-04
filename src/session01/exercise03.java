package session01;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        //Khai báo biến
        double radius;//bán kinh
        double area;//diện tích

        //Tạo đối tượng để nhập
        Scanner scanner = new Scanner(System.in);

        //Yêu cầu nhập bán kính
        System.out.print("Vui lòng nhập bán kinh: ");
        radius = scanner.nextDouble();

        //Tính diện tích hình tròn
        area = Math.PI * radius * radius;

        //Hiển thị kết quả
        System.out.printf("Diện tích hình tròn có bán kính %.2f là: %.2f%n", radius, area);

        //Đóng Scanner
        scanner.close();
    }
}
