package session08.Exercise08;

public class Electronics extends Product{
    public Electronics() {}

    public Electronics(String name, double price) {
        super(name, price);
    }

    //Electronics có chiết khấu 10%
    @Override
    public double getDiscount() {
        return 10;
    }

    public String toString() {
        return "Tên hàng: " + name + ", Giá: " + getFinalPrice();
    }
}
