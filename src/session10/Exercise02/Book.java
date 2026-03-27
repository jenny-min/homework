package session10.Exercise02;

public class Book {
    //Thuộc tính
    private String title;
    private String author;
    private int year;

    //Constructor
    public Book() {}

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //Getter and Setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Tên sách: " + title + ", Tên tác giả: " + author + ", Năm xuất bản: " + year;
    }
}
