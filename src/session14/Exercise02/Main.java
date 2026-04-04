package session14.Exercise02;

import session14.Exercise01.Student;
import session14.Exercise01.StudentManager;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Student student = new Student(1, "Nguyễn Văn A", 21); // ID của sinh viên cần cập nhật
        manager.updateStudent(student);
    }
}
