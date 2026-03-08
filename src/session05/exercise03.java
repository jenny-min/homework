package session05;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập chuỗi
        System.out.print("Nhập chuỗi ký tự: ");
        String input = sc.nextLine().trim();

        //thay thế tất cả các ký tự số (0-9) trong chuỗi đó bằng ký tự
        String replaceString = input.replaceAll("[0-9]", "*");

        //Hiển thị
        System.out.print("Chuỗi sau khi thay thế: " + replaceString);

        //Đóng scanner
        sc.close();
    }
}
