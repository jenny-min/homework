package session05;

import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập chuỗi người dùng
        System.out.print("Nhập địa chỉ email: ");
        String email = sc.nextLine().trim();

        //Biểu thức regex
        String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+(\\.[a-zA-Z]{2,6})+$";
        //Kiểm tra định dạng email
        if (email.matches(emailRegex)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }

        //Đóng scanner
        sc.close();
    }
}
