package session12.Exercise02;

import session12.Exercise02.ra.business.AppointmentBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentBusiness business = new AppointmentBusiness();

        while (true) {
            System.out.println("******** QUẢN LÝ LỊCH HẸN ********");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã lịch hẹn");
            System.out.println("5. Xóa lịch hẹn theo mã lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> business.add(sc);
                case 2 -> business.display();
                case 3 -> business.search(sc);
                case 4 -> business.update(sc);
                case 5 -> business.delete(sc);
                case 6 -> business.statistics();
                case 0 -> System.exit(0);
                default -> System.out.println("Không hợp lệ!");
            }
        }
    }
}
