package session09.Exercise01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        do {
            System.out.println("*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tim sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1://Hiển thị danh sách
                    if (studentList.isEmpty()) {
                        System.out.println("Danh sách sinh viên trống");
                    } else {
                        for (Student student : studentList) {
                            student.displayData();
                        }
                    }
                    break;
                case 2://Thêm
                    System.out.println("Nhập số sinh viên cần thêm: ");
                    int n = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < n; i++) {
                        Student student = new Student();
                        System.out.println("Nhập sinh viên thứ " + (i + 1));
                        System.out.println("-+-+-+-");
                        student.inputData(sc);
                        studentList.add(student);
                    }
                    break;
                case 3://Cập nhật theo mã SV
                    System.out.println("Nhập mã sinh viên cần cập nhật: ");
                    String updateId = sc.nextLine();
                    boolean foundUpdate = false;

                    for (Student student : studentList) {
                        if (student.getId().equals(updateId)) {
                            System.out.println("Nhập thông tin mới: ");
                            student.inputData(sc);
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("Mã sinh viên không tồn tại");
                    }
                    break;
                case 4://Xóa theo mã SV
                    System.out.println("Nhập mã sinh viên cần xóa: ");
                    String deleteId = sc.nextLine();
                    boolean foundDelete = false;

                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getId().equals(deleteId)) {
                            studentList.remove(i);
                            foundDelete = true;
                            System.out.println("Đã xóa!");
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Mã sinh viên không tồn tại");
                    }
                    break;
                case 5://Tìm theo mã SV
                    System.out.println("Nhập mã sinh viên cần tìm: ");
                    String searchName = sc.nextLine().toLowerCase();
                    int count = 0;

                    for (Student student : studentList) {
                        student.displayData();
                        count++;
                    }

                    System.out.println("Sô sinh viên tìm thấy: " + count);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ!Vui lòng nhập lại");
            }
        } while (true);
    }
}
