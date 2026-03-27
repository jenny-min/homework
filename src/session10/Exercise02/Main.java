package session10.Exercise02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();

        while (true){
            System.out.println("*************** MENU QUẢN LÝ SÁCH ***************");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm kiếm sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Thoát");
            try {
                int choice = InputData.getInt(scanner, "Nhập lựa chọn của bạn: ");

                switch (choice) {
                    case 1://Thêm sách
                        String title = InputData.getString(scanner, "Nhập tên sách: ");
                        String author = InputData.getString(scanner, "Nhập tác giả: ");
                        int year = InputData.getInt(scanner, "Nhập năm xuất bản: ");
                        Book book = new Book(title, author, year);
                        manager.addBook(book);
                        System.out.println("Sách đã được thêm thành công!");
                        break;

                    case 2://Tìm kiếm theo tên
                        System.out.println("Nhập tên sách cần tìm: ");
                        String searchTitle = scanner.nextLine();
                        try {
                            Book foundBook = manager.findBook(searchTitle);
                            System.out.println("Thông tin sách tìm thấy: \n" + foundBook);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3://Hiển thị
                        System.out.println("\nDanh sách sách: ");
                        manager.displayBooks();
                        break;
                    case 4://Thoát
                        System.exit(0);
                        //Đóng scanner
                        scanner.close();
                        return;
                    default:
                        System.err.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
                }

            } catch (NumberFormatException e) {
                System.err.println("Lỗi nhập liệu! Vui lòng chọn lại!");
            }
        }

    }
}
