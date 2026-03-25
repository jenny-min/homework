package session09.Exercise03.ra.entity;

import java.util.Scanner;

public class Product implements IShop{
    //Thuộc tính
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrP, int indexP,
                          Categories[] arrC, int indexC) {

        // ID
        while (true) {
            System.out.print("Nhập mã SP (C/S/A + 3 ký tự): ");
            String id = scanner.nextLine();
            if (id.matches("^[CSA]\\w{3}$") && !isDuplicateId(id, arrP, indexP)) {
                this.productId = id;
                break;
            }
            System.out.println("Sai hoặc trùng!");
        }

        // Name
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            if (name.length() >= 10 && name.length() <= 50 && !isDuplicateName(name, arrP, indexP)) {
                this.productName = name;
                break;
            }
            System.out.println("Tên sản phẩm sai!");
        }

        // Price
        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            try {
                float p = Float.parseFloat(scanner.nextLine());
                if (p > 0) {
                    this.price = p;
                    break;
                }
            } catch (Exception e) {}
            System.out.println("Giá không hợp lệ!");
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();

        // Chọn danh mục
        System.out.println("Chọn danh mục:");
        for (int i = 0; i < indexC; i++) {
            arrC[i].displayData();
        }

        while (true) {
            System.out.print("Nhập mã danh mục: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (existsCatalog(id, arrC, indexC)) {
                this.catalogId = id;
                break;
            }
            System.out.println("Không tồn tại!");
        }

        // Status
        while (true) {
            System.out.print("Nhập trạng thái (0/1/2): ");
            int st = Integer.parseInt(scanner.nextLine());
            if (st >= 0 && st <= 2) {
                this.productStatus = st;
                break;
            }
        }
    }

    private boolean isDuplicateId(String id, Product[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i].productId.equals(id)) return true;
        }
        return false;
    }

    private boolean isDuplicateName(String name, Product[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i].productName.equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    private boolean existsCatalog(int id, Categories[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i].getCatalogId() == id) return true;
        }
        return false;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %s, | Tên sản phẩm: %s | Giá: %.2f | Mã danh mục: %d | Trạng thái: %d\n", productId, productName, price, catalogId, productStatus);
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }
}
