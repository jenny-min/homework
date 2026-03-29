package session10.Exercise07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        int choice = 0;

        do {
            System.out.println("********** MENU QUẢN LÝ SINH VIÊN **********");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm theo tên");
            System.out.println("4. Phân loại theo GPA");
            System.out.println("5. Thoát");

            try {
                System.out.println("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lỗi nhập liệu! Vui lòng nhập lại");
            }

            switch (choice) {
                case 1://Thêm
                    studentManager.inputStudent(scanner);
                    break;
                case 2://Hiển thị
                    studentManager.displayStudents();
                    break;
                case 3://Tìm kiếm theo tên
                    studentManager.searchByName(scanner);
                    break;
                case 4://Phân loại theo GPA
                    studentManager.displayByRank();
                    break;
                case 5://Thoát
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lỗi nhập liệu! Vui lòng nhập từ 1 đến 5");
                    break;
            }
        } while (true);
    }
}
