package session01;

import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {
        //Tạo sối tượng để nhập
        Scanner scanner = new Scanner(System.in);

        //Yêu cầu nhập tử số và mẫu số
        System.out.println("Vui lòng nhập tử số thứ 1:");
        int a = (int) scanner.nextDouble();
        System.out.println("Vui lòng nhập mẫu số thứ 1:");
        int b = (int) scanner.nextDouble();
        System.out.println("Vui lòng nhập tử 1" +
                "số thứ 2:");
        int c = (int) scanner.nextDouble();
        System.out.println("Vui lòng nhập mẫu số thứ 2:");
        int d = (int) scanner.nextDouble();

        //tính tổng
        int tuso = a * d + b * c;
        int mauso = b * d;

        //Hiển thị
        System.out.printf("Phân số 1: %d/%d, Phân số 2: %d/%d, Kết quả: %d/%d", a, b, c, d, tuso, mauso);

        //Đóng scanner
        scanner.close();
    }
}
