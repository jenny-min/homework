package session10.Exercise04;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student>{
    public ArrayList<Student> students;

    public AttendanceManager() {
        students = new ArrayList<>();
    }

    //kiểm tra danh sách trống
    public boolean isEmpty() {
        return students.isEmpty();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(int index, Student student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }
        }
    }
}
