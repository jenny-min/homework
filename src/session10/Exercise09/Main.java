package session10.Exercise09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        int choice;

        do {
            System.out.println("\n***** MENU QUẢN LÝ DANH BẠ ĐIỆN THOẠI *****");
            System.out.println("1. Nhập danh bạ");
            System.out.println("2. Thêm liên lạc");
            System.out.println("3. Xóa liên lạc");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Hiển thị danh bạ");
            System.out.println("6. Phân trang");
            System.out.println("7. Thoát");

            try {
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập lại");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.inputData(scanner);
                    break;

                case 2:
                    String name = manager.inputString(scanner, "Nhập tên người liên lạc: ");
                    String phone = manager.inputString(scanner, "Nhập số điện thoại: ");
                    manager.add(new session10.Exercise09.Contact(name, phone));
                    break;

                case 3:
                    manager.remove(manager.inputString(scanner, "Nhập số điện thoại cần xóa: "));
                    break;

                case 4:
                    manager.search(manager.inputString(scanner, "Nhập số điện thoại cần tìm: "));
                    break;

                case 5:
                    manager.display();
                    break;

                case 6:
                    manager.displayPaging(scanner);
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.err.println("Lỗi nhập liệu! Vui lòng chọn lại");
            }

        } while (true);
    }
}
