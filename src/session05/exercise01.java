package session05;

import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập văn bản
        System.out.println("Nhập vào chuỗi văn bản: ");
        String text = sc.nextLine().trim();

        //Nhập từ cần tìm
        System.out.println("Nhập từ cần tìm: ");
        String key = sc.nextLine().trim();

        //Tìm vị trí của từ trong chuỗi
        int index = text.indexOf(key);

        //Kiểm tra và hiển thị kết quả
        if (index != -1) {
            System.out.println("Từ \"" + key + "\" xuất hiện tại vị trí " + index + " trong chuỗi.");
        } else {
            System.out.println("Không tìm thấy từ \"" + key + "\" trong chuỗi.");
        }

        //Đóng scanner
        sc.close();
    }
}
