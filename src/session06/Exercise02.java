package session06;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise02 {
    static String name = "";
    static String email = "";
    static String phone = "";
    static String password = "";

    public static void main(String[] args) {
        //Đối tượng nhập
        Scanner sc = new Scanner(System.in);
        int choice;

        //Menu
        do {
            System.out.println("******************QUẢN LÝ NGƯỜI DÙNG****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.println("****************************************************");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                    //1. Nhập thông tin người dùng
                case 1:
                    System.out.println("+++++ Nhập thông tin người dùng +++++");
                    System.out.println("Họ và tên: ");
                    name = sc.nextLine();
                    System.out.println("Email: ");
                    email = sc.nextLine();
                    System.out.println("Số điện thoại: ");
                    phone = sc.nextLine();
                    System.out.println("Mật khẩu: ");
                    password = sc.nextLine();
                    System.out.println("+++++ +++++ +++++ +++++ +++++ +++++ +++++");
                    break;

                    //2. Chuẩn hóa họ và tên
                case 2:
                    name = normalizeName(name);
                    System.out.println("Họ và tên sau khi chuẩn hóa: " + name);
                    break;

                    //3. Kiểm tra email hợp lệ
                case 3:
                    if (checkEmail(email)) {
                        System.out.println("Email hợp lệ");
                    } else {
                        System.out.println("Email không hợp lệ");
                    }
                    break;

                    //4. Kiểm tra số điện thoại
                case 4:
                    if (checkPhone(phone)) {
                        System.out.println("Số điện thoại hợp lệ");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ");
                    }
                    break;

                    //5. Kiểm tra mật khẩu
                case 5:
                    if (checkPassword(password)) {
                        System.out.println("Mật khẩu hợp lệ");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ");
                    }
                    break;

                    //6. Thoát
                case 6:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        } while (choice !=6);

        //Đóng scanner
        sc.close();
    }

    //Chuẩn hóa họ tên
    public static String normalizeName (String name) {
        //chuyển về chữ thường + loại bỏ khoảng trống đầu cuối
        name = name.toLowerCase().trim();
        String[] words = name.split("\\s+"); //tách từng chữ

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            //Viết hoa chữ cái đầu, nối chữ cái tiếp theo, thêm khoảng trắng
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }

        //Trả về String và loại bỏ khoảng trắng đầu cuối
        return result.toString().trim();
    }

    //Kiểm tra email
    public static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9_.-]+@[a-zA-Z]+\\.[a-z]$";
        return Pattern.matches(regex, email);
    }

    //Kiểm tra số điện thoại VN(đầu số mobiPhone hoặc Viettel thông dụng)
    public static boolean checkPhone(String phone) {
        String regex = "^(03|05|07|08|09)[0-9]{8}$";
        return Pattern.matches(regex, phone);
    }

    //Kiểm tra mật khẩu
    public static boolean checkPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(regex, password);
    }
}
