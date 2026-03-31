package session11.Exercise08;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Quý", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 25)),
                new Order(2, "Lan", LocalDate.of(2025, 3, 21), null),
                new Order(3, "Minh", LocalDate.of(2025, 3, 22), LocalDate.of(2025, 3, 23)),
                new Order(4, "Huyền", LocalDate.of(2025, 3, 23), null),
                new Order(5, "Việt", LocalDate.of(2025, 3, 23), LocalDate.of(2025, 3, 30))
        );

        // 1. Đơn đã giao
        System.out.println("=== Đơn đã giao ===");
        orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent())
                .forEach(o -> System.out.println(o.toDisplayString()));

        // 2. Đơn chưa giao
        System.out.println("\n=== Đơn chưa giao ===");
        orders.stream()
                .filter(o -> o.getDeliveryDate().isEmpty())
                .forEach(o -> System.out.println(o.toDisplayString()));

        // 3. Đếm đơn đã giao trong khoảng ngày
        LocalDate from = LocalDate.of(2025, 3, 17);
        LocalDate to = LocalDate.of(2025, 3, 23);

        long count = orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent())
                .filter(o -> {
                    LocalDate d = o.getDeliveryDate().get();
                    return !d.isBefore(from) && !d.isAfter(to);
                })
                .count();

        System.out.println("\nSố đơn đã giao từ 17-03-2025 đến 23-03-2025: " + count);

        // 4. In tất cả đơn
        System.out.println("\n=== Tất cả đơn hàng ===");
        orders.forEach(o -> System.out.println(o.toDisplayString()));
    }
}
