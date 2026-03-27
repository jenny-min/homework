package session10.Exercise03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager manager = new UserManager();
        int choice = -1;

        while (true) {
            //Menu
            System.out.println("********* MENU QUẢN LÝ NGƯỜI DÙNG **********");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");

            try {
               choice = InputData.getInt(scanner, "Lựa chọn của bạn: ");

                switch (choice) {
                    case 1://Thêm người dùng
                        String name = InputData.getString(scanner, "Nhập tên người dùng: ");
                        String email = InputData.getString(scanner, "Nhập email người dùng: ");
                        String phoneNumber = InputData.getString(scanner, "Nhập số điện thoại người dùng: ");

                        User user = new User(name, email, phoneNumber);
                        manager.addUser(user);
                        System.out.println("Người dùng đã được thêm thành công");
                        break;
                    case 2://Xóa người dùng
                        String emailToRemove = InputData.getString(scanner, "Nhập email người dùng muốn xóa: ");
                        if (manager.removeUser(emailToRemove)) {
                            System.out.println("Người dùng đã được xóa thành công");
                        } else {
                            System.out.println("Không tìm thấy người dùng có email này!");
                        }
                        break;
                    case 3://Hiển thị danh sách người dùng
                        System.out.println("\nDanh sách người dùng: ");
                        manager.displayUser();
                        break;
                    case 4://Thoát
                        System.exit(0);
                        scanner.close();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu! Vui lòng chọn một số hợp lệ!");
            }
        }
    }
}
