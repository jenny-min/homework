package session08.Exercise07;

public class Developer extends Employee{
    private String programmingLanguage;

    public Developer(){}

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Tên lập trình viên: " + name + ", Mã số: " + id + ", Lương cơ bản: " + salary + ", Ngôn ngữ lập trình: " + programmingLanguage;
    }
}
