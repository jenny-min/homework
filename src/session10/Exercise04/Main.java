package session10.Exercise04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();
        int choice;

        while (true) {
            //Menu
            System.out.println("********** MENU QUẢN LÝ ĐIỂM DANH **********");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");

            try {
                choice = Integer.parseInt(InputData.getString(scanner, "Lựa chọn của bạn: "));

                switch (choice) {
                    case 1://Thêm sinh viên
                        int studentId = InputData.getInt(scanner,"Nhập id sinh viên: ");
                        String studentName = InputData.getString(scanner,"Nhập tên sinh viên: ");
                        Student student = new Student(studentId, studentName);
                        manager.add(student);
                        System.out.println("Thêm sinh viên thành công!");
                        break;
                    case 2://Sửa sinh viên
                        if (manager.isEmpty()) {
                            System.out.println("Danh sách sinh viên trống!");
                            break;
                        }
                        manager.display();
                        int update = InputData.getInt(scanner,"Nhập id sinh viên cần sửa: ");
                        int index = -1;
                        for (int i = 0; i < manager.students.size(); i++) {
                            if (manager.students.get(i).getStudentId() == update) {
                                index = i;
                                break;
                            }
                        }
                        if (index == -1) {
                            System.out.println("Không tìm thấy sinh viên có id này!");
                        } else {
                            String newName = InputData.getString(scanner,"Nhập tên mới sinh viên: ");
                            manager.update(index, new Student(update, newName));
                            System.out.println("Sinh viên đã được sửa thành công!");
                        }
                        break;
                    case 3://Xóa sinh viên
                        if (manager.isEmpty()) {
                            System.out.println("Danh sách sinh viên trống!");
                            break;
                        }
                        manager.display();
                        int deleteId = InputData.getInt(scanner,"Nhập id sinh viên cần xóa: ");
                        int indexDelete = -1;
                        for (int i = 0; i < manager.students.size(); i++) {
                            if (manager.students.get(i).getStudentId() == deleteId) {
                                indexDelete = i;
                                break;
                            }
                        }
                        if (indexDelete == -1) {
                            System.out.println("Không tìm thấy sinh viên cần xóa");
                        } else {
                            manager.delete(indexDelete);
                            System.out.println("Đã xóa sinh viên thành công!");
                        }
                        break;
                    case 4://Hiển thí danh sách
                        manager.display();
                        break;
                    case 5://Thoát
                        System.exit(0);
                        scanner.close();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Nhập liệu không hợp lệ! Vui lòng nhập lại");
            }
        }
    }
}
