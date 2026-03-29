package session10.Exercise07;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;
    public StudentManager() {
        students = new ArrayList<>();
    }

    int n;

    //nhập danh sách
    public void inputStudent(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập số lượng sinh viên: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n >= 5) break;
                System.out.println("Phải nhập ít nhất 5 sinh viên!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ");
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ": ");
            Student student = new Student();
            try {
                System.out.println("Nhập ID sinh viên: ");
                student.setId(Integer.parseInt(scanner.nextLine()));
                System.out.println("Nhập tên sinh viên: ");
                student.setName(scanner.nextLine());
                System.out.println("Nhập điểm GPA: ");
                student.setGpa(Double.parseDouble(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu! Vui lòng nhập lại sinh viên!");
                i--;
                continue;
            }
            students.add(student);
        }
    }

    //Hiển thị danh sách
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        students.forEach(System.out::println);
    }

    //Tìm theo tên
    public void searchByName(Scanner scanner) {
        System.out.println("Nhập tên cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(keyword)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên");
        }
    }

    //Hiển thị theo phân loại
    public void displayByRank() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }

        System.out.println("Xuất sắc");
        students.stream().filter(student -> student.getGpa() >= 8.5).forEach(System.out::println);
        System.out.println("Giỏi");
        students.stream().filter(student -> student.getGpa() >= 7 && student.getGpa() < 8.5).forEach(System.out::println);
        System.out.println("Khá");
        students.stream().filter(student -> student.getGpa() >= 5.5 && student.getGpa() < 7).forEach(System.out::println);
        System.out.println("Trung bình/");
        students.stream().filter(student -> student.getGpa() < 5.5).forEach(System.out::println);
    }
}
