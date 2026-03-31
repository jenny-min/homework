package session12.Exercise01.ra.entity;

import java.util.List;
import java.util.Scanner;

public class Product {
    private static int autoId = 1;
    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    // Constructor rỗng
    public Product() {
        this.productId = autoId++;
    }

    // Constructor đầy đủ
    public Product(String productName, float price, String category, int quantity) {
        this.productId = autoId++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Getter
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // inputData
    public void inputData(Scanner scanner, List<Product> productList) {
        // tên
        while (true) {
            System.out.print("Nhập tên sản phẩm (5-50 ký tự): ");
            String name = scanner.nextLine().trim();

            if (name.length() < 5 || name.length() > 50) {
                System.out.println("Tên phải từ 10-50 ký tự!");
                continue;
            }

            boolean isExist = productList.stream()
                    .anyMatch(p -> p.getProductName().equalsIgnoreCase(name));

            if (isExist) {
                System.out.println("Tên sản phẩm bị trùng!");
                continue;
            }

            this.productName = name;
            break;
        }

        // giá
        while (true) {
            try {
                System.out.print("Nhập giá sản phẩm: ");
                float price = Float.parseFloat(scanner.nextLine());

                if (price <= 0) {
                    System.out.println("Giá phải > 0! Vui lòng nhập lại!");
                    continue;
                }

                this.price = price;
                break;
            } catch (Exception e) {
                System.out.println("Giá phải > 0! Vui lòng nhập lại!");
            }
        }

        // category
        while (true) {
            System.out.print("Nhập danh mục sản phẩm: ");
            String cate = scanner.nextLine();

            if (cate.length() > 200) {
                System.out.println("Quá 200 ký tự! Vui lòng nhập ít hơn 200 ký tự");
                continue;
            }

            this.category = cate;
            break;
        }

        // quantity
        while (true) {
            try {
                System.out.print("Nhập số lượng sản phẩm: ");
                int qty = Integer.parseInt(scanner.nextLine());

                if (qty < 0) {
                    System.out.println("Số lượng sản phẩm phải >= 0! Vui lòng nhập lại");
                    continue;
                }

                this.quantity = qty;
                break;
            } catch (Exception e) {
                System.out.println("Số lượng sản phẩm phải >= 0! Vui lòng nhập lại");
            }
        }
    }

    @Override
    public String toString() {
        return productId + " | Tên sản phẩm: " + productName + " | Giá: " + price + " | Danh mục sản phẩm: " + category + " | Số lượng: " + quantity;
    }

}
