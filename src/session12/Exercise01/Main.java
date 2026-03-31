package session12.Exercise01;

import session12.Exercise01.ra.business.ProductBusiness;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductBusiness business = new ProductBusiness();

        while (true) {
            System.out.println("*********************QUẢN LÝ SẢN PHẨM********************");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo mã sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Sắp xếp sản phẩm theo số lượng giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    business.addProduct(scanner);
                    break;
                case 2:
                    business.display();
                    break;
                case 3:
                    business.update(scanner);
                    break;
                case 4:
                    business.delete(scanner);
                    break;
                case 5:
                    business.search(scanner);
                    break;
                case 6:
                    business.sortByPrice();
                    break;
                case 7:
                    business.sortByQuantityDesc();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
