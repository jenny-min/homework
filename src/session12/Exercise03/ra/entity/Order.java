package session12.Exercise03.ra.entity;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private static int currentId = 1;

    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private OrderStatus status;

    // Constructor rỗng
    public Order() {
        this.orderId = currentId++;
        this.status = OrderStatus.PENDING;
    }

    // Constructor đầy đủ
    public Order(String customerName, String phoneNumber, String address, float orderAmount, OrderStatus status) {
        this.orderId = currentId++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    // Getter/Setter
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        do {
            if (customerName.length() >= 6 && customerName.length() <= 100) {
                this.customerName = customerName;
            } else {
                System.err.println("Tên khách hàng phải từ 6-100 ký tự!");
                break;
            }
        } while (true);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        do {
            String regex = "^(0[3|5|7|8|9])[0-9]{8}$";
            if (Pattern.matches(regex, phoneNumber)) {
                this.phoneNumber = phoneNumber;
            } else {
                System.err.println("Số điện thoại không hợp lệ!");
            }
        } while (true);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        do {
            if (!address.trim().isEmpty()) {
                this.address = address;
            } else {
                System.err.println("Địa chỉ không được để trống!");
            }
        } while (true);
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        do {
            if (orderAmount > 0) {
                this.orderAmount = orderAmount;
            } else {
                System.err.println("Giá trị đơn hàng phải > 0!");
            }
        } while (true);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // Nhập dữ liệu
    public void inputData(Scanner scanner) {
        try {
            System.out.print("Nhập tên khách hàng: ");
            setCustomerName(scanner.nextLine());

            System.out.print("Nhập số điện thoại: ");
            setPhoneNumber(scanner.nextLine());

            System.out.print("Nhập địa chỉ: ");
            setAddress(scanner.nextLine());

            System.out.print("Nhập giá trị đơn hàng: ");
            setOrderAmount(Float.parseFloat(scanner.nextLine()));

        } catch (Exception e) {
            System.out.println("Lỗi nhập liệu: " + e.getMessage());
            inputData(scanner); // nhập lại
        }
    }

    @Override
    public String toString() {
        return "- Mã đơn hàng: " + orderId
                + "\n- Tên khách hàng: " + customerName
                + "\n- SĐT: " + phoneNumber
                + "\n- Địa chỉ giao hàng: " + address
                + "\n- Giá trị đơn hàng: " + orderAmount
                + "\n- Trạng thái đơn hàng: " + status;
    }
}
