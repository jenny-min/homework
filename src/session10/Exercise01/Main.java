package session10.Exercise01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        String continueInput;

        do {
            String name = InputData.getString(scanner, "Nhập tên sinh viên: ");
            int age = InputData.getInt(scanner, "Nhập tuổi sinh viên: ");
            double gpa = InputData.getDouble(scanner, "Nhập điểm trung bình sinh viên: ");

            Student student = new Student(name, age, gpa);
            manager.addStudent(student);

            continueInput = InputData.getString(scanner, "Bạn có muốn thêm sinh viên khác? (y/n): ");

        } while (continueInput.equalsIgnoreCase("y"));
        //Khi chọn n thì chạy code bên dưới để hiển thị danh sách sinh viên vừa nhập

        System.out.println("\nDanh sách sinh viên: ");
        manager.displayStudent();

        //Đóng scanner
        scanner.close();
    }
}
