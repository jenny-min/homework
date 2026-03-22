package session08.Exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoryManagement categoryManagement = new CategoryManagement();
        int choice;

        do {
            System.out.println("\n-----MENU-----");
            System.out.println("1. Thêm danh mục");
            System.out.println("2. Hiển thị danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thoát");
            System.out.println("--------------");
            System.out.println("Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1://Thêm danh mục
                    System.out.println("Nhập ID danh mục: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập tên danh mục: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập mô tả danh mục: ");
                    String description = sc.nextLine();
                    categoryManagement.addCategory(new Category(id, name, description));
                    System.out.println("Danh mục đã được thêm");
                    break;
                case 2://hiển thị danh mục
                    Category[] categories = categoryManagement.findAll();
                    if (categories.length == 0) {
                        System.out.println("Danh sách danh mục rỗng!");
                        break;
                    }
                    System.out.println("Danh sách danh mục: ");
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    break;
                case 3://Cập nhật danh mục
                    System.out.println("Nhập ID danh mục cần cập nhật: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    System.out.println("Nhập mô tả mới: ");
                    String newDesctiption = sc.nextLine();
                    categoryManagement.updateCategory(new Category(updateId, newName, newDesctiption));
                    System.out.println("Danh mục đã được cập nhập");
                    break;
                case 4://Xóa danh mục
                    System.out.println("Nhập ID danh mục cần xóa: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    categoryManagement.deleteById(deleteId);
                    break;
                case 5://Thoát
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }
        } while (choice != 5);

        //Đóng Scanner
        sc.close();
    }
}