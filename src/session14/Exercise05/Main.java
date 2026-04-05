package session14.Exercise05;

import session14.Exercise05.business.service.OrderService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.placeOrder(1, BigDecimal.valueOf(30000000),2 , 5);
    }
}
