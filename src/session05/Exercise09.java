package session05;

import java.util.Scanner;
import java.util.regex.*;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Người dùng nhập url
        System.out.println("Nhập URL: ");
        String url = sc.nextLine();

        //Dùng matcher viết gọn
        Matcher matcher = Pattern.compile("^(http|https)://([^/]+)(/.*)?$").matcher(url);

        if (matcher.matches()) {
            String path = matcher.group(3);

            if (path == null) {
                path = "(không có)";
            }

            System.out.println("URL hợp lệ!");
            System.out.println("Giao thức: " + matcher.group(1));
            System.out.println("Tên miền: " + matcher.group(2));
            System.out.println("Đường dẫn: " + path);
        } else {
            System.out.println("URL không hợp lệ!");
        }

        //Đóng scanner
        sc.close();
    }
}
