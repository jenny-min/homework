package session02;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        //Tạo đối tượng để người dùng nhập vào giá trị
        Scanner sc = new Scanner(System.in);

        //Yêu cầu người dùng nhập vào 1 số nguyên dương
        System.out.println("Vui lòng nhập 1 số nguyên: ");
        int n = sc.nextInt();

        //Kiểm tra số nguyên dương
        if (n <= 0) {
            System.out.print("Số nhập vào không hợp lệ.");
        } else {
            //Khai báo biến lưu trữ tổng
            int sum = 0;

            //Vòng lặp for
            for (int i = 0; i <= n; i++) {
                //Tính tổng
                sum += i;
            }

            // Hiển thị kết quả
            System.out.printf("Tổng các số từ 1 đến %d là: %d", n, sum);
        }

        //Đóng scanner
        sc.close();
    }
}
