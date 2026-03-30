package session11.Exercise04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        while (true) {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add product");
            System.out.println("2. Edit product");
            System.out.println("3. Delete product");
            System.out.println("4. Display product");
            System.out.println("5. Filter product (Price > 100)");
            System.out.println("6. Total value of product");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Product p = new Product();
                    p.inputData(scanner);
                    manager.addProduct(p);
                    break;

                case 2:
                    System.out.print("Enter Product ID to edit: ");
                    int idUpdate = Integer.parseInt(scanner.nextLine());
                    manager.updateProduct(idUpdate, scanner);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    manager.deleteProduct(idDelete);
                    break;

                case 4:
                    manager.displayAll();
                    break;

                case 5:
                    manager.filterPriceGreaterThan100();
                    break;

                case 6:
                    manager.totalPrice();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
