package session01;

import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        //Khai báo biến
        float width;
        float height;
        float area;
        float circumference;

        //Tạo đối tượng để nhập
        Scanner scanner = new Scanner(System.in);

        //Nhập chiều dài và chiều rộng
        System.out.println("Vui lòng nhập chiều dài của hình chữ nhật:");
        width = scanner.nextFloat();
        System.out.println("Vui lòng nhập vào chiều rộng của hình chữ nhật");
        height = scanner.nextFloat();

        //tính diện tích và chu vi
        area = width * height;
        circumference = 2 * (width + height);

        //Hiển thị
        System.out.printf("Diện tích hình chữ nhật là: %.0f\n", area);
        System.out.printf("Chu vi hình chữ nhật là: %.0f", circumference);

        //Đóng scanner
        scanner.close();
    }
}
