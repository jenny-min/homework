package session08.Exercise08;

public class Clothing extends Product{
    public Clothing() {}

    public Clothing(String name, double price) {
        super(name, price);
    }

    //Clothing có chiết khấu 20%
    @Override
    public double getDiscount() {
        return 20;
    }

    public String toString() {
        return "Tên hàng: " + name + ", Giá: " + getFinalPrice();
    }
}
