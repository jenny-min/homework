package session08.Exercise08;

public class Main {
    public static void main(String[] args) {
        //Tạo đối tượng
        Product product = new Product("Hàng phổ thông", 1000);
        Electronics electronics = new Electronics("Laptop", 2500);
        Clothing clothing = new Clothing("Jean", 500);
        Food food = new Food("Gạo", 800);

        //Hiển thị danh sách hàng hóa
        System.out.println("Danh sách hàng hóa: ");
        System.out.println(product.toString());
        System.out.println(electronics.toString());
        System.out.println(clothing.toString());
        System.out.println(food.toString());

        //Hiển thị giá, không xét số lượng
        System.out.println("\n-----Không xét số lượng-----");
        System.out.println(product.getFinalPrice());
        System.out.println(electronics.getFinalPrice());
        System.out.println(clothing.getFinalPrice());
        System.out.println(food.getFinalPrice());

        //In giá khi mua dưới 100 sản phẩm
        System.out.println("\n-----Mua 50 sản phẩm-----");
        System.out.println(product.getFinalPrice(50));
        System.out.println(electronics.getFinalPrice(50));
        System.out.println(clothing.getFinalPrice(50));
        System.out.println(food.getFinalPrice(50));

        //In giá khi mua trên 100 sản phẩm
        System.out.println("\n----Mua 150 sản phẩm-----");
        System.out.println(product.getFinalPrice(150));
        System.out.println(electronics.getFinalPrice(150));
        System.out.println(clothing.getFinalPrice(150));
        System.out.println(food.getFinalPrice(150));
    }
}
