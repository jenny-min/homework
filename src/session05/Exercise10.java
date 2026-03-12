package session05;

import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập đoạn văn bản: ");
        String text = sc.nextLine();

        if (text.trim().isEmpty()) {
            System.out.println("Không có văn bản để xử lý.");
        }

        text = text.toLowerCase().trim().replaceAll("[^a-zA-Z0-9 ]", " ").replaceAll("\\s+", " ");
        /* //Xóa ký tự đặc biệt
        text = text.replaceAll("[^a-zA-Z0-9 ]", "");

        //Chuyển sang chữ thường
        text = text.toLowerCase();

        //Xóa khoảng trắng dư
        text = text.trim().replaceAll("\\s+", " "); */

        //Trích xuất số
        Matcher matcher = Pattern.compile("\\d+").matcher(text);

        ArrayList<String> numbers = new ArrayList<>();

        while (matcher.find()) {
            numbers.add(matcher.group());
        }

        //Hiển thị
        System.out.println("Văn bản chuẩn hóa: " + text);
        System.out.println("Danh sách số tìm được: " + numbers);

        //Đóng scanner
        sc.close();
    }
}
