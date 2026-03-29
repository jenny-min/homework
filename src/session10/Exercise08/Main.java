package session10.Exercise08;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();

        int choice = 0;

        do {
            //MENU quản lý
            System.out.println("********** MENU QUẢN LÝ SÁCH **********");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Lọc & sắp xếp sách theo năm xuất bản");
            System.out.println("4. Thoát");

            try {
                System.out.println("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập lại!");
            }

            switch (choice) {
                case 1://Thêm
                    bookManager.inputBook(scanner);
                    break;
                case 2://Hiển thi
                    bookManager.display();
                    break;
                case 3://Lọc và sắp xếp
                    System.out.println("Nhập năm cần lọc: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    List<Book> result = bookManager.filterByYear(year);//Lọc theo năm
                    bookManager.sortByTitle(result);//Sắp xếp theo tên

                    System.out.println("Danh sách sau khi lọc và sắp xếp: ");
                    bookManager.displayBooks(result);
                    break;
                case 4://Thoát
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lỗi nhập liệu! Vui lòng nhập lại!");
            }

        } while (true);
    }
}
