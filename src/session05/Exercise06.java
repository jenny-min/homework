package session05;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String password;

        // Regex kiểm tra mật khẩu
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%]).{8,}$";

        do {
            System.out.print("Nhập mật khẩu: ");
            password = sc.nextLine();

            if (!password.matches(regex)) {
                System.out.println("Mật khẩu không hợp lệ!");
            }

        } while (!password.matches(regex));

        System.out.println("Mật khẩu hợp lệ!");
    }
}
