package session10.Exercise08;

import java.util.*;

public class BookManager {
    //Khởi tạo BST sách
    private Set<Book> books = new HashSet<>();

    //Thêm sách vào BST - Tự loại trùng lặp
    public void addBook(Book book) {
        if (books.add(book)) {
            System.out.println("Thêm sách thành công");
        } else {
            System.out.println("ID sách đã tồn tại!");
        }
    }

    //Nhập sách
    public void inputBook(Scanner scanner) {
        int n;
        while (true) {
            try {
                System.out.println("Nhập số lượng sách muốn thêm: ");
                n = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập lại!");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sách thứ: " + (i + 1));
            try {
                System.out.println("Nhập mã số sách: ");
                String id = scanner.nextLine();
                System.out.println("Nhập tên sách: ");
                String title = scanner.nextLine();
                System.out.println("Nhập tên tác giả: ");
                String author = scanner.nextLine();
                System.out.println("Nhập năm xuất bản: ");
                int year = Integer.parseInt(scanner.nextLine());
                //Thêm vào BST
                addBook(new Book(id, title, author, year));
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập lại");
                i--;
            }
        }
    }

    //Lọc theo năm xuất bản
    public List<Book> filterByYear(int year) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }
        return result;
    }

    //Sắp xếp theo tên
    public void sortByTitle(List<Book> list) {
        list.sort(Comparator.comparing(Book::getTitle));
    }

    //Hiển thị danh sách
    public void displayBooks(List<Book> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        list.forEach(System.out::println);
    }

    public void display() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        books.forEach(System.out::println);
    }
}
