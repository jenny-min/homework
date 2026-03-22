package session08.Exercise08;

public class Food extends Product{
    public Food() {}

    public Food(String name, double price) {
        super(name, price);
    }

    //Food có chiết khấu 5%
    @Override
    public double getDiscount() {
        return 5;
    }

    public String toString() {
        return "Tên hàng: " + name + ", Giá: " + getFinalPrice();
    }
}
