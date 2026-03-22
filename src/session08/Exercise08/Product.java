package session08.Exercise08;

public class Product {
    protected String name;
    protected double price;

    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getDiscount() {
        return 0;
    }

    public double getFinalPrice() {
        return price - (price * getDiscount()) / 100;
    }

    //Chiết khấu theo số lượng
    public double getDiscount(int quantity) {
        if (quantity > 100) {
            return 5;//5% cho tất cả các loại hàng
        } else {
            return getDiscount();//Chiết khấu mặc định của từng loại hàng
        }
    }

    //Giá sau khi chiết khấu theo số lượng
    public double getFinalPrice(int quantity) {
        double discount = getDiscount(quantity);
        return price - (price * discount) / 100;
    }

    @Override
    public String toString() {
        return "Tên hàng: " + name + ", Giá: " + price;
    }
}
