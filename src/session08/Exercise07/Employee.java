package session08.Exercise07;

public class Employee {
    //Thuộc tính
    protected int id;
    protected String name;
    protected double salary;

    //Constructor k tham số
    public Employee(){};

    //Constructor có tham số
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    //Lấy lương
    public double getSalary() {
        return salary;
    }

    //Tăng lương
    public void increaseSalary(double amount) {
        this.salary += amount;
    }

    //Hiển thị
    @Override
    public String toString() {
        return "Nhân viên: " + name + ", Mã số: " + id + ", Lương: " + salary;
    }
}
