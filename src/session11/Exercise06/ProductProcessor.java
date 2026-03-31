package session11.Exercise06;

import java.util.List;

public interface ProductProcessor {
    // abstract
    double calculateTotalValue(List<Product> products);

    // static
    static void printProductList(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }
    }

    // default
    default boolean hasExpensiveProduct(List<Product> products) {
        for (Product p : products) {
            if (p.getPrice() > 100) {
                return true;
            }
        }
        return false;
    }
}
