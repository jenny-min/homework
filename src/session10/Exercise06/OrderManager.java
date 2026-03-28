package session10.Exercise06;

import java.util.ArrayList;

public class OrderManager implements Manage<Order>{
    public ArrayList<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    //Kiểm tra danh sách trống
    public boolean isEmpty() {
        return orders.isEmpty();
    }

    @Override
    public void add(Order order) {
       orders.add(order);
    }

    @Override
    public void update(int index, Order order) {
        if (index >= 0 && index < orders.size()) {
            orders.set(index, order);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index< orders.size()) {
            orders.remove(index);
        }
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống!");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println((i + 1) + ". " + orders.get(i));
            }
        }
    }
}
