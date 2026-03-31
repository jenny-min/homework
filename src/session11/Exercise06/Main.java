package session11.Exercise06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1200));
        products.add(new Product("Mouse", 25));
        products.add(new Product("Keyboard", 80));
        products.add(new Product("Phone", 900));

        ProductProcessorImpl processor = new ProductProcessorImpl();

        // kiểm tra sản phẩm đắt
        if (processor.hasExpensiveProduct(products)) {
            processor.printExpensiveProducts(products);
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        // tính tổng
        double total = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị: " + total);

        // in danh sách
        ProductProcessor.printProductList(products);
    }
}
