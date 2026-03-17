package session06;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise03 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> list = new ArrayList<>();

    //regex biển số xe
    static final String regex ="^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$";

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                //1. Thêm biển số
                case 1:
                    addLicensePlate();
                    break;
                //2. Hiển thị danh sách
                case 2:
                    displayList();
                    break;

                //3. Tìm kiếm
                case 3:
                    searchExact();
                    break;

                //4. Tìm kiếm theo tỉnh
                case 4:
                    searchByProvince();
                    break;

                //5. Sắp xếp tăng dần
                case 5:
                    sortAscending();
                    break;

                //6. Thoát
                case 6:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        } while (choice != 6);
    }

    //Menu
    static void menu() {
        System.out.println("\n******** QUẢN LÝ BIỂN SỐ XE ********");
        System.out.println("1. Thêm các biển số xe");
        System.out.println("2. Hiển thị danh sách biển số xe");
        System.out.println("3. Tìm kiếm biển số xe");
        System.out.println("4. Tìm biển số xe theo mã tỉnh");
        System.out.println("5. Sắp xếp biển số tăng dần");
        System.out.println("6. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    //1. Thêm biển số
    static void addLicensePlate() {
        System.out.println("Nhập biển số xe: ");
        String plate = sc.nextLine();

        if (plate.matches(regex)) {
            list.add(plate);
            System.out.println("Thêm biển số xe thành công!");
        } else {
            System.err.println("Biển số xe không hợp lệ!");
        }
    }

    //2. Hiển thị danh sách
    static void displayList() {
        if (list.isEmpty()) {
            System.out.println("Danh sách biển số xe trống!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Danh sách biển số xe:\n");

        for (String plate : list) {
            sb.append(plate).append("\n");
        }

        System.out.println(sb);
    }

    //3. Tìm kiếm
    static void searchExact() {
        System.out.println("Nhập biển số xe cần tìm (VD: 00A-000.00): ");
        String input = sc.nextLine();

       if (list.contains(input)) {
           System.out.println("Tìm thấy biển số xe!");
       } else {
           System.out.println("Không tìm thấy biển số xe!");
       }
    }

    //4. Tìm kiếm theo tỉnh
    static void searchByProvince() {
        System.out.println("Nhập mã tỉnh (VD: 00): ");
        String code = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (String plate : list) {
            if (plate.startsWith(code)) {
                sb.append(plate).append("\n");
                found = true;
            }
        }

        if (found) {
            System.out.println("Danh sách biển số xe theo tỉnh: ");
            System.out.println(sb);
        } else {
            System.out.println("Không có biển số nào thuộc tỉnh này!");
        }
    }

    //5. Sắp xếp tăng dần
    static void sortAscending() {
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append("Danh sách đã sắp xếp: \n");

        for (String plate : list) {
            sb.append(plate).append("\n");
        }

        System.out.println(sb);
    }
}
