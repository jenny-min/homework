package session02;

import java.util.Scanner;

public class exercise09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("Nhập số nguyên dương: ");

        // Kiểm tra dữ liệu nhập
        // hasNextInt : là phương thức của lớp Scanner
        // dùng để kiểm tra dữ liệu nhập vào có phải là số nguyên (int)?
        while (true) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n >= 0) {
                    break;
                }
            } else {
                sc.next(); // bỏ dữ liệu sai
            }
            System.out.println("Số nhập vào không hợp lệ");
        }

        System.out.println("Các số Armstrong từ 0 đến " + n + " là:");

        // Duyệt các số từ 0 đến N
        for (int i = 0; i <= n; i++) {

            int sum = getSum(i);

            // Kiểm tra Armstrong
            if (sum == i) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }

    private static int getSum(int i) {
        int temp = i;
        int digits = 0;

        // Đếm số chữ số
        int count = temp;
        while (count > 0) {
            digits++;
            count /= 10;
        }

        if (i == 0) digits = 1;

        int sum = 0;

        // Tính tổng lũy thừa
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }

        if (i == 0) sum = 0;
        return sum;
    }
}
