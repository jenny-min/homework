package session02;

import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        //tạo đối tượng để người dùng nhập
        Scanner sc = new Scanner(System.in);

        //Yêu cầu người dùng nhập vào 1 số nguyên
        System.out.println("Hãy nhập vào một số nguyên: ");
        int n = sc.nextInt();

        //Chuyển số âm thành số dương
        n = Math.abs(n);

        //Tạo biến tổng ban đầu
        int sum = 0;

        //Tách từng chữ số
        while (n > 0) {
            int digit = n % 10; //Lấy chữ số cuối
            sum += digit; //Cộng vào tổng
            n = n / 10; //bỏ chữ số cuối
        }

        //Hiển thị
        System.out.println("Tổng các chữ số là: "+ sum);

        //Đóng scanner
        sc.close();
    }
}
