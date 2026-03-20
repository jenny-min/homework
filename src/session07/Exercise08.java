package session07;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise08 {
    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Menu
        do {
            System.out.println("-+-+-+-+-+-+-+-+-+-MENU-+-+-+-+-+-+-+-+-+-");
            System.out.println("1. Hiển thị tất cả danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên dựa vào mã sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.println("-+-+-+-+-+-+--+-+-+-+-+-+--+-+-+-+-+-+-+-+");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: //Hiển thị tất cả danh sách sinh viên
                    displayAll();
                    break;
                case 2: // Thêm mới sinh viên
                    addStudent();
                    break;
                case 3: // Sửa thông tin sinh viên dựa vào mã SV
                    updateById();
                    break;
                case 4: // Xóa sinh viên
                    deleteStudent();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }
        } while (true);
    }

    //Class enum Gender
    public enum Gender {
        MALE, FEMALE, OTHER;
    }

    //Class Student
    public static class Student {
        //Thuộc tính
        private int id;
        private String name;
        private int age;
        private Gender gender;
        private String address;
        private String phoneNumber;

        //constructor k tham số
        public Student(){};

        //constructor có tham số
        public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        //getter và setter
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        //Nhập dữ liệu sinh viên
        public void inputData() {
            System.out.println("Nhập ID sinh viên: ");
            this.id = Integer.parseInt(sc.nextLine());

            System.out.println("Nhập họ và tên sinh viên: ");
            this.name = sc.nextLine();

            System.out.println("Nhập tuổi sinh viên: ");
            this.age = Integer.parseInt(sc.nextLine());

            System.out.println("Nhập giới tính sinh viên (male/female/other): ");
            this.gender = Gender.valueOf(sc.nextLine().toUpperCase());

            System.out.println("Nhập địa chỉ: ");
            this.address = sc.nextLine();

            System.out.println("Nhập số điện thoại: ");
            this.phoneNumber = sc.nextLine();
        }

        //Hiển thị dữ liệu
        public void displayData() {
            System.out.println("- ID: " + id);
            System.out.println("- Họ và tên: " + name);
            System.out.println("- Tuổi: " + age);
            System.out.println("- Giới tính: " + gender);
            System.out.println("- Địa chỉ: " + address);
            System.out.println("- SĐT: " + phoneNumber);
            System.out.println("******");
        }
    }

    //Hiển thị tất cả
    public static void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng");
            return;
        }
        for (Student s : list) {
            s.displayData();
        }
    }

    //Thêm mới sinh viên
    public static void addStudent() {
        Student s = new Student();
        s.inputData();
        list.add(s);
        System.out.println("Đã thêm sinh viên thành công!");
    }

    //Cập nhật sinh viên
    public static void updateById() {
        System.out.println("Nhập mã sinh viên cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println("Nhập lại thông tin: ");
                System.out.println("-+-+-+-+-");
                s.inputData();
                System.out.println("Sinh viên có mã " + id + " đã được cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã sinh sinh này!");
    }

    //Xóa sinh viên
    public static void deleteStudent() {
        System.out.println("Nhập mã sinh viên muốn xóa!");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                System.out.println("Xóa sinh viên thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy mã sinh viên này!");
    }
}
