package session08.Exercise06;

public class Book {
    //Thuộc tính
    private String title;
    private String author;
    private String isbn;
    private int year;

    //Constructor
    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDetails() {
        return "Tiêu đề: " + title + ", Tác giả: " + author + ", Năm: ";
    }
}
