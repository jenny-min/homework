package session11.Exercise04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager {
    private Map<Integer, Product> products = new HashMap<>();
    private int currentId = 1;

    // Thêm sản phẩm
    public void addProduct(Product p) {
        p = new Product(currentId++, p.getName(), p.getPrice());
        products.put(p.getId(), p);
        System.out.println("Product add successfully with ID: " + p.getId());
    }

    // Sửa sản phẩm
    public void updateProduct(int id, Scanner scanner) {
        if (!products.containsKey(id)) {
            System.out.println("Product not found!");
            return;
        }

        Product p = products.get(id);

        System.out.print("Enter new Product Name: ");
        String name = scanner.nextLine();


        System.out.print("Enter new Product ID: ");
        double price = Double.parseDouble(scanner.nextLine());

        products.put(id, new Product(id, name, price));
        System.out.println("Product update successfully!");
    }

    // Xóa sản phẩm
    public void deleteProduct(int id) {
        if (products.remove(id) != null) {
            System.out.println("Product delete successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Hiển thị tất cả
    public void displayAll() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        products.values().forEach(Product::display);
    }

    // Lọc giá > 100 (STREAM)
    public void filterPriceGreaterThan100() {
        List<Product> result = products.values().stream()
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không có sản phẩm nào > 100");
        } else {
            result.forEach(Product::display);
        }
    }

    // Tổng giá trị (STREAM)
    public void totalPrice() {
        double sum = products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Tổng giá trị: " + sum);
    }
}
