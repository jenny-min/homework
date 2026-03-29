package session10.Exercise09;

import java.util.Objects;

public class Contact {
    private static int autoId = 1;

    private int id;
    private String name;
    private String phoneNumber;

    public Contact() {}

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Gán id khi add thành công
    public void assignId() {
        this.id = autoId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Không trùng SĐT
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact c = (Contact) o;
        return phoneNumber.equals(c.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "Mã số liên lạc: " + id + ", Tên người liên lạc: " + name + ", Số điện thoại: " + phoneNumber;
    }
}
