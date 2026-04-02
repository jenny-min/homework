package session12.Exercise03;

import session12.Exercise03.ra.business.OrderBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderBusiness orderBusiness = new OrderBusiness();

        do {
            System.out.println("*********************QUẢN LÝ ĐƠN HÀNG********************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị danh sách đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng theo mã đơn hàng");
            System.out.println("4. Xóa đơn hàng theo mã đơn hàng");
            System.out.println("5. Tìm kiếm đơn hàng theo tên khách hàng");
            System.out.println("6. Thống kê tổng số đơn hàng");
            System.out.println("7. Thống kê tổng doanh thu các đơn hàng có trạng thái Delivered");
            System.out.println("8. Thống kê số lượng đơn hàng theo từng trạng thái");
            System.out.println("9. Tìm kiếm đơn hàng có giá trị lớn nhất");
            System.out.println("10. Thoát");
            System.out.println("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1://Thêm đơn hàng
                    orderBusiness.addOrder(scanner);
                    break;
                case 2://Hiển thị danh sách đơn hàng
                    orderBusiness.displayOrder();
                    break;
                case 3://Cập nhật trạng thái đơn hàng
                    System.out.println("Nhập ID đơn hàng cần cập nhật: ");
                    orderBusiness.updateStatus(Integer.parseInt(scanner.nextLine()));
                    break;
                case 4://Xóa đơn hàng theo ID
                    System.out.println("Nhập ID đơn hàng cần xóa: ");
                    orderBusiness.deleteOrder(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5://Tìm kiếm đơn hàng theo tên
                    System.out.println("Nhập tên khách hàng cần tìm: ");
                    orderBusiness.searchByName(scanner.nextLine());
                    break;
                case 6://Thống kê tổng đơn hàng
                    orderBusiness.totalOrders();
                    break;
                case 7://Thống kê doanh thu
                    orderBusiness.totalRevenue();
                    break;
                case 8://Thống kê theo trạng thái
                    orderBusiness.countByStatus();
                    break;
                case 9://Tìm đơn có giá trị lớn nhất
                    orderBusiness.maxOrder();
                    break;
                case 10://Thoát
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }
        } while (true);
    }
}
