package session10.Exercise07;

public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student() {
    }

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Phân loại GPA
    public String getRank() {
        if (gpa >= 8.5) {
            return "Xuất sắc";
        } else if (gpa >= 7.0) {
            return "Giỏi";
        } else if (gpa >= 5.5) {
            return "Khá";
        } else {
            return "Trung bình/Yếu";
        }
    }

    @Override
    public String toString() {
        return "Mã sinh viên: " + id + ", Họ và tên sinh viên: " + name + ", Phân loại: " + gpa + ", Xếp loại: " + getRank();
    }
}
