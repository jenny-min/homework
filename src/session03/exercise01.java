package session03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.00");

        // Nhập thông tin
        System.out.println("\n=== NHẬP THÔNG TIN HÓA ĐƠN ===");
        System.out.print("Nhập tên khách hàng: ");
        String customerName = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String productName = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();

        System.out.print("Nhập số lượng mua: ");
        int quantity = sc.nextInt();

        System.out.print("Khách có thẻ thành viên (true/false): ");
        boolean isMember = sc.nextBoolean();

        // Tính toán
        double amount = price * quantity;

        double discount = 0;
        if (isMember) {
            discount = amount * 0.10;
        }

        double vat = amount * 0.08;

        double total = amount - discount + vat;

        // In hóa đơn
        System.out.println("\n===== HÓA ĐƠN MUA HÀNG =====");
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm: " + productName);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Đơn giá: " + df.format(price) + " VND");
        System.out.println("Thành tiền: " + df.format(amount) + " VND");
        System.out.println("Giảm giá thành viên (10%): " + df.format(discount) + " VND");
        System.out.println("Tiền VAT (8%): " + df.format(vat) + " VND");
        System.out.println("Tổng thanh toán: " + df.format(total) + " VND");
        System.out.println("==============================");

        sc.close();
    }
}