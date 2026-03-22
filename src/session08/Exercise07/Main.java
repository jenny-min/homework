package session08.Exercise07;

public class Main {
    public static void main(String[] args) {
        //Tạo đối tượng
        Employee employee1 = new Employee("Nguyễn Văn A", 001, 5000);
        Manager manager1 = new Manager("Nguyễn Thị C", 002, 7000, 2000);
        Developer developer1 = new Developer("Đỗ Cường", 003, 6000, "Java");

        //Hiển thị lương
        System.out.println("Lương nhân viên: " + employee1.getSalary());
        System.out.println("Lương quản lý: " + manager1.getSalary());
        System.out.println("Lương lập trình viên: " + developer1.getSalary());
        System.out.println("-----+-----+-----");

        //Hiển thị thông tin
        System.out.println(employee1);
        System.out.println(manager1);
        System.out.println(developer1);
        System.out.println("-----+-----+-----");

        //Tăng lương nhân viên
        developer1.increaseSalary(1000);

        //Hiển thị thông tin sau khi tăng lương
        System.out.println("Thông tin nhân viên sau khi tăng lương: ");
        System.out.println(developer1);
    }
}
