package session12.Exercise03.ra.business;

import java.util.*;
import java.util.stream.Collectors;

import session12.Exercise03.ra.entity.*;
public class OrderBusiness {
    private List<Order> orders = new ArrayList<>();

    //Thêm đơn hàng
    public void addOrder (Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        orders.add(order);
        System.out.println("Thêm đơn hàng thành công!");
    }

    //Hiển thị danh sách đơn hàng theo thứ tự giảm dần
    public void displayOrder() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống");
        } else {
            orders.stream()
                    .sorted(((o1, o2) -> Float.compare(o2.getOrderAmount(), o1.getOrderAmount())))
                    .forEach(System.out::println);
        }
    }

    //Cập nhật trạng thái
    public void updateStatus(int id) {
        Order order = findById(id);
        if (order == null) {
            System.out.println("Không tìm thấy đơn hàng cần cập nhật!");
            return;
        }

        switch (order.getStatus()) {
            case PENDING -> order.setStatus(OrderStatus.SHIPPED);
            case SHIPPED -> order.setStatus(OrderStatus.DELIVERED);
            case DELIVERED -> System.out.println("Đơn hàng đã được giao! Không thể cập nhật!");
        }

        System.out.println("Cập nhật đơn hàng thành công!");
    }

    //Xóa đơn hàng
    public void deleteOrder(int id) {
        Order order = findById(id);
        if (order != null && order.getStatus() == OrderStatus.PENDING) {
            orders.remove(order);
            System.out.println("Xóa đơn hàng thành công!");
        } else {
            System.err.println("Chỉ được xóa đơn hàng PENDING!");
        }
    }

    //Tìm theo ID
    private Order findById(int id) {
        return orders.stream().filter(order -> order.getOrderId() == id).findFirst().orElse(null);
    }

    //Tìm theo tên
    public void searchByName(String name) {
        List<Order> result = orders.stream()
                .filter(order -> order.getCustomerName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        result.forEach(System.out::println);
    }

    //Thống kê tổng đơn hàng
    public void totalOrders() {
        System.out.println("Tổng số đơn hàng: " + orders.size());
    }

    //Thống kê tổng doanh thu
    public void totalRevenue() {
        float sum = (float) orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.DELIVERED)
                .mapToDouble(Order::getOrderAmount)
                .sum();

        System.out.println("Tổng doanh thu: " + sum);
    }

    //Thống kê số lượng đơn hàng theo từng trạng thái
    public void countByStatus() {
        Map<OrderStatus, Long> map = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    //Tìm đơn hàng có giá trị lớn nhất
    public void maxOrder() {
        orders.stream().max(Comparator.comparing(Order::getOrderAmount))
                .ifPresent(System.out::println);
    }
}
