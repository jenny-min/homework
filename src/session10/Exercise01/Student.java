package session10.Exercise01;

//Lớp Student chứa thuộc tính, constructor, phương thức getter and setter và hiển thị danh sách
public class Student {
    //Thuộc tính
    private String name;
    private int age;
    private double gpa;//Điểm trung bình

    //constructor
    public Student() {
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    //Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Tuổi: " + age + ", Điểm trung bình: " + gpa;
    }
}
