package session11.Exercise08;

import java.time.LocalDate;
import java.util.Optional;

public class Order {
    private int id;
    private String customerName;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;

    // Constructor rỗng
    public Order() {
    }

    // Constructor đầy đủ (cho phép truyền null)
    public Order(int id, String customerName, LocalDate createdDate, LocalDate deliveryDate) {
        this.id = id;
        this.customerName = customerName;
        this.createdDate = createdDate;
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    // Setter
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    // Hiển thị
    public String toDisplayString() {
        String delivery = deliveryDate
                .map(LocalDate::toString)
                .orElse("Chưa giao");

        return id + " | " + customerName + " | " + createdDate + " | " + delivery;
    }
}
