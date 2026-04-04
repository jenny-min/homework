package session13.Exercise05.business.model;

public class Movie {
    private Integer id;
    private String title;
    private String director;
    private int year;

    public Movie() {
    }

    public Movie(Integer id, String title, String director, int year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Phim{" +
                "ID: " + id +
                ", Tên phim: '" + title + '\'' +
                ", Nhà sản xuất: '" + director + '\'' +
                ", Năm sản xuất: " + year +
                '}';
    }
}
