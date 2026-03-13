package session07;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Exercise05 {
    private static List<Product> productList = new ArrayList<>();
    //Phương thức main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean found = false;

        //Menu
        do {
            System.out.println("Menu:");
            System.out.println("1: Thêm mới sản phẩm");
            System.out.println("2: Hiển thị danh sách sản phẩm");
            System.out.println("3: Cập nhật sản phẩm");
            System.out.println("4: Xóa sản phẩm");
            System.out.println("5: Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            //switch case
            switch (choice) {
                //Thêm mới sản phẩm
                case 1:
                    System.out.print("Nhập ID sản phẩm: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = sc.nextDouble();
                    productList.add(new Product(id, name, price));
                    System.out.println("Sản phẩm đã được thêm.");
                    break;

                //Hiển thị sản phẩm
                case 2:
                    if (productList.isEmpty()) {
                        System.out.println("Danh sách sản phẩm trống.");
                    }
                    System.out.println("Danh sách sản phẩm: ");
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getProductId() + " ,Tên: " + product.getProductName() + " ,Giá: " + product.getPrice());
                    }
                    break;

                //Cập nhật sản phẩm
                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String updateId = sc.nextLine();
                    for (Product product : productList) {
                        if (product.getProductId().equals(updateId)) {
                            System.out.print("Nhập tên sản phẩm mới: ");
                            product.setProductName(sc.nextLine());
                            System.out.print("Nhập giá mới: ");
                            product.setPrice(sc.nextDouble());
                            found = true;
                            System.out.println("Sản phẩm đã được cập nhật.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Sản phẩm không tồn tại.");
                    }
                    break;

                //Xóa sản phẩm
                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String deleteId = sc.nextLine();
                    found = false;
                    for (int i = 0; i < productList.size(); i++) {
                        if (productList.get(i).getProductId().equals(deleteId)) {
                            productList.remove(i);
                            found = true;
                            System.out.println("Sản phẩm đã được xóa.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Sản phẩm không tồn tại.");
                    }
                    break;

                //Thoát
                case 5:
                    System.out.println("Thoát khỏi chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice !=5);

        //Đóng scanner
        sc.close();
    }

    //Lớp product
    public static class Product {
        //Thuộc tính
        private String productId;
        private String productName;
        private double price;

        //Constructor
        public Product(String productId, String productName, double price) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
        }

        //setter và getter
        public String getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
