package session10.Exercise01;

import java.util.ArrayList;
//Chứa phương thức nhập thông tin và hiển thị danh sách sinh viên
public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudent() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
