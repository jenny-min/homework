package session09.Exercise03.ra.entity;

import java.util.Scanner;

public class Categories implements IShop{
    Scanner input = new Scanner(System.in);
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // Getter/Setter
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // Input
    public void inputData(Scanner scanner, Categories[] arr, int index) {
        // ID tự tăng
        if (index == 0) {
            this.catalogId = 1;
        } else {
            this.catalogId = arr[index - 1].catalogId + 1;
        }

        // Name
        while (true) {
            System.out.print("Nhập tên danh mục: ");
            String name = scanner.nextLine();
            if (name.length() <= 50 && !isDuplicateName(name, arr, index)) {
                this.catalogName = name;
                break;
            }
            System.out.println("Tên bị trùng hoặc quá 50 ký tự!");
        }

        System.out.print("Nhập mô tả: ");
        this.descriptions = scanner.nextLine();

        while (true) {
            System.out.print("Nhập trạng thái (true/false): ");
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            }
            System.out.println("Chỉ nhập true hoặc false!");
        }
    }

    private boolean isDuplicateName(String name, Categories[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i].catalogName.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d | Tên danh mục: %s | Mô tả danh mục: %s | Trạng thái: %s\n", catalogId, catalogName, descriptions, catalogStatus);
    }
}
