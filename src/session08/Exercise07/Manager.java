package session08.Exercise07;

public class Manager extends Employee{
    //Thuộc tính
    private double bonus;

    //Constructor
    public Manager() {}

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);//Gọi constructor cha
        this.bonus = bonus;
    }

    //Ghi đè getSalary
    @Override
    public double getSalary() {
        return salary + bonus;
    }

    @Override
    public String toString() {
        return "Tên quản lý: " + name + ", Mã số quản lý: " + id + ", Lương cơ bản: " + salary + ", Tiền thưởng: " + bonus + ", Tổng lương: " + getSalary();
    }
}
