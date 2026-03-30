package session11.Exercise04;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void inputData(java.util.Scanner scanner) {
        System.out.print("Enter Product Name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        this.price = Double.parseDouble(scanner.nextLine());
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Price: " + price);
    }
}
