package session08.Exercise06;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements IBookManager {
    //Thuộc tính
    private List<Book> books;
    public BookManager() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Đã thêm sách: " + book.getDetails());
    }

    @Override
    public void removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                System.out.println("Đã xóa sách với ISBN: " + isbn);
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ISBN " + isbn);
    }

    //Hiển thị
    @Override
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Không có sách trong danh sách!");
            return;
        }
        System.out.println("Danh sách sách: ");
        for (Book book : books) {
            System.out.println(book.getDetails());
        }
    }
}