package session12.Exercise01.ra.business;

import session12.Exercise01.ra.entity.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductBusiness {
    private List<Product> products = new ArrayList<>();

    // thêm
    public void addProduct(Scanner scanner) {
        Product p = new Product();
        p.inputData(scanner, products);
        products.add(p);
        System.out.println("Thêm sản phẩm thành công!");
    }

    // hiển thị
    public void display() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        products.forEach(System.out::println);
    }

    // tìm theo id
    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst()
                .orElse(null);
    }

    // cập nhật
    public void update(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy sản phẩm nào!");
            return;
        }

        p.inputData(scanner, products);
        System.out.println("Cập nhật sản phẩm thành công!");
    }

    // xóa
    public void delete(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy sản phẩm cần xóa!");
            return;
        }

        products.remove(p);
        System.out.println("Xóa sản phẩm thành công!");
    }

    // tìm kiếm gần đúng
    public void search(Scanner scanner) {
        System.out.print("Nhập sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        products.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(keyword))
                .forEach(System.out::println);
    }

    // sort giá tăng
    public void sortByPrice() {
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println("Đã sắp xếp theo giá tăng!");
    }

    // sort quantity giảm
    public void sortByQuantityDesc() {
        products.sort((a, b) -> b.getQuantity() - a.getQuantity());
        System.out.println("Đã sắp xếp theo số lượng giảm!");
    }
}
