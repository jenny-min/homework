package session08.Exercise10;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();

        paymentMethods.add(new CreditCard(1000));
        paymentMethods.add(new DebitCard(1000));
        paymentMethods.add(new Cash(500));

        for (PaymentMethod p : paymentMethods) {
            System.out.println("\n---Thông tin thanh toán---");
            System.out.println("Phí: " + p.calculateFee());
            System.out.println("Tổng số tiền phải trả: " +p.processPayment());
            System.out.println("Loại tiền tệ: " + p.processPayment("USD"));
        }
    }
}
