package session07;

import java.util.Scanner;

public class Exercise03 {
    //Phương thức main
    public static void main(String[] args) {
        //Đối tượng để nhập
        Scanner sc = new Scanner(System.in);

        //Tạo đối tượng thứ 1
        Person person1 = new Person();
        System.out.print("Nhập tên người thứ nhất: ");
        person1.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ nhất: ");
        person1.setAge(sc.nextInt());
        sc.nextLine();

        //Tạo đối tượng thứ 2
        Person person2 = new Person();
        System.out.print("Nhập tên người thứ hai: ");
        person2.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ hai: ");
        person2.setAge(sc.nextInt());

        //so sánh tuổi
        if (person1.getAge() > person2.getAge()) {
            System.out.println(person1.getName() + " lớn tuổi hơn " + person2.getName());
        } else if (person1.getAge() < person2.getAge()) {
            System.out.println(person1.getName() + " nhỏ tuổi hơn " + person2.getName());
        } else {
            System.out.println("Cả hai bằng tuổi nhau.");
        }
    }

    //Class Person
    public static class Person {
        //Thuộc tính
        private String name;
        private int age;

        //Phương thức setter và getter
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
    }
}
