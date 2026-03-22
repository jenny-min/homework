package session09.Exercise01;

import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private int age;
    private String major;

    public Student(){}

    public Student(String id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã sinh viên: ");
        this.id = scanner.nextLine();
        System.out.println("Nhập họ và tên: ");
        this.name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        this.age = scanner.nextInt();
        System.out.println("Nhập chuyên ngành: ");
        this.major = scanner.nextLine();
        System.out.println("----------");
    }

    public void displayData() {
        System.out.println("- Mã sinh viên: " + id +
                "\n- Họ và tên: " + name +
                "\n- Tuổi: " + age +
                "\n- Chuyên ngành: " + major);
    }
}
