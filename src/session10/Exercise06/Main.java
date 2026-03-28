package session10.Exercise06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        int choice;

        while (true) {
            System.out.println("********** MENU QUẢN LÝ ĐƠN HÀNG **********");
            System.out.println("1.Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị đơn hàng");
            System.out.println("5. Thoát");

            try{
                choice = InputData.getInt(scanner, "Lựa chọn của bạn: ");

                switch (choice) {
                    case 1://Thêm
                        String id = InputData.getString(scanner, "Nhập mã đơn hàng: ");
                        String name = InputData.getString(scanner, "Nhập tên khách hàng: ");
                        Order order = new Order(id, name);
                        orderManager.add(order);
                        System.out.println("Đơn hàng đã được thêm thành công!");
                        break;
                    case 2://Sửa
                        orderManager.display();
                        String update = InputData.getString(scanner, "Nhập mã đơn hàng cần sửa: ");
                        int index = -1;
                        for (int i = 0; i < orderManager.orders.size(); i++) {
                            if (orderManager.orders.get(i).getId().equals(update)){
                                index = i;
                                break;
                            }
                        }
                        if (index == -1) {
                            System.out.println("Không tìm thấy đơn hàng có id " +update);
                        } else {
                            String newId = InputData.getString(scanner,"Nhập mã đơn hàng mới: ");
                            String newName = InputData.getString(scanner, "Nhập tên khách hàng mới: ");
                            orderManager.update(index, new Order(newId, newName));
                            System.out.println("Đơn hàng đã được sửa thành công!");
                        }
                        break;
                    case 3://Xóa
                        if (orderManager.orders.isEmpty()) {
                            System.out.println("Danh sách đơn hàng trống!");
                            break;
                        }
                        orderManager.display();
                        String delete = InputData.getString(scanner, "Nhập mã đơn hàng cần xóa: ");
                        index = -1;
                        for (int i = 0; i < orderManager.orders.size(); i++) {
                            if (orderManager.orders.get(i).getId().equals(delete)) {
                                index = i;
                                break;
                            }
                        }
                        if (index == -1) {
                            System.out.println("Không tìm thấy đơn hàng có id " + delete);
                        } else {
                            orderManager.delete(index);
                            System.out.println("Đơn hàng đã được xóa thành công!");
                        }
                        break;
                    case 4://Hiển thị
                        orderManager.display();
                        break;
                    case 5://Thoát
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }
        }
    }
}
