package session08.Exercise06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        int choice;

        //MENU
        do {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Thoát");
            System.out.println("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1://Thêm sách
                    System.out.println("Nhập tiêu đề: ");
                    String title = sc.nextLine();
                    System.out.println("Nhập tác giả: ");
                    String author = sc.nextLine();
                    System.out.println("Nhập ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.println("Nhập năm xuất bản: ");
                    int year = sc.nextInt();
                    bookManager.addBook(new Book(title, author, isbn, year));
                    break;
                case 2://Hiển thị sách
                    bookManager.displayBooks();
                    break;
                case 3://Xóa
                    System.out.println("Nhập ISBN sách cần xóa: ");
                    String isbnToRemove = sc.nextLine();
                    bookManager.removeBook(isbnToRemove);
                    break;
                case 4://Thoát
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
            }

        } while (choice != 4);

        //Đóng scanner
        sc.close();
    }
}
