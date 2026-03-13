package session07;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise04 {
    //Phương thức main
    public static void main(String[] args) {
        //Danh sách sinh viên
        Student[] studentArray = new Student[3];

        studentArray[0] = new  Student("Bob", 21, "A1", 7.0);
        studentArray[1] = new  Student("Eve", 20, "A1", 8.0);
        studentArray[2] = new  Student("Jack", 21, "A1", 5.0);

        //Nhập điểm
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm min: ");
        double min = sc.nextDouble();
        System.out.print("Nhập điểm max: ");
        double max = sc.nextDouble();

        //Hiển thị
        System.out.println("Danh sách sinh viên có điểm trung bình từ 7.0 đến 8.0: ");
        for (Student student : studentArray) {
            if (student.getAvgScore() >= min && student.getAvgScore() <= max) {
                System.out.println(student);
            }
        }

        //Đóng scanner
        sc.close();
    }



    //Lớp Student
    public static class Student {
        //Thuộc tính
        private String name;
        private int age;
        private String className;
        private double avgScore;

        //Constructor
        public Student(String name, int age, String className, double avgScore) {
            this.name = name;
            this.age = age;
            this.className = className;
            this.avgScore = avgScore;
        }

        // Getters
        public String getName() {
            return name;
        }

        public double getAvgScore() {
            return avgScore;
        }


        //Display
        public String toString() {
            return "Tên: " + name + ", Tuổi: " + age + ", Lớp: " + className + ", Điểm trung bình: " + avgScore;
        }
    }
}
