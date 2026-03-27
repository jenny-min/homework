package session10.Exercise02;

import java.util.HashMap;

public class BookManager {
    private HashMap<String, Book> books;

   public BookManager() {
       books = new HashMap<>();
   }

    //thêm sách
    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }
    //tìm sách theo tên
    public Book findBook(String title) throws Exception{
        if (!books.containsKey(title)) {
            throw new Exception("Sách không tồn tại!");
        }
        return books.get(title);
    }
    //hiển thị danh sách
    public void displayBooks() {
       if (books.isEmpty()) {
           System.out.println("Danh sách sách trống!");
       } else {
           for (Book book : books.values()) {
               System.out.println(book);
           }
       }
    }
}
