package session11.Exercise06;

import java.util.List;
import java.util.function.Predicate;

public class ProductProcessorImpl implements ProductProcessor{

    @Override
    public double calculateTotalValue(List<Product> products) {
        double total = 0;

        for (Product p : products) {
            total += p.getPrice();
        }

        return total;
    }

    // thêm method hỗ trợ lọc sản phẩm đắt
    public void printExpensiveProducts(List<Product> products) {
        Predicate<Product> isExpensive = p -> p.getPrice() > 100;

        System.out.println("Sản phẩm đắt tiền:");
        for (Product p : products) {
            if (isExpensive.test(p)) {
                System.out.println(p);
            }
        }
    }
}
