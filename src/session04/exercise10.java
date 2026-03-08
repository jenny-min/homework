package session04;

import java.util.Scanner;

public class exercise10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100]; //giả sử mảng tối đa 100 phần tử
        int n = 0; // số phần tử hiện tại
        int choice;//tạo biến choice để nhập lựa chọn

        //dùng do ...while để lặp menu liên tục
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm một phần tử vào mảng.");
            System.out.println("2. Xóa một phần tử trong mảng theo chỉ số (index).");
            System.out.println("3. Hiển thị mảng");
            System.out.println("4. Sắp xếp mảng theo giá trị giảm dần.");
            System.out.println("5. Tìm kiếm một phần tử trong mảng.");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = sc.nextInt();

            //dùng swich case để chọn menu
            switch (choice) {
                case 1: //Thêm phần tử
                    System.out.println("Nhập số cần thêm: ");
                    int value = sc.nextInt();

                    arr[n] = value;
                    n++;

                    System.out.println("Đã thêm phần tử.");
                    break;

                case 2: //xóa phần tử theo index
                    System.out.println("Nhập index cần xóa: ");
                    int index = sc.nextInt();

                    if (index < 0 || index >= n) {
                        System.out.println("Index này không hợp lệ!");
                    } else {
                        for (int i = index; i < n - 1; i++) {
                            arr[i] = arr[i + 1];
                        }

                        n--;

                        System.out.println("Đã xóa phần tử!");
                    }
                    break;

                case 3: //Hiển thị mảng
                    if (n == 0) {
                        System.out.println("Mảng rỗng");
                    } else {
                        System.out.println("Mảng hiện tại: ");
                        for (int i = 0; i < n; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 4: //Sắp xếp giảm dần
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {

                            if (arr[i] < arr[j]) {

                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;

                            }
                        }
                    }

                    System.out.println("Đã sắp xếp giảm dần.");
                    break;

                case 5: //Tìm kiếm phần tử
                    System.out.println("Nhập số cần tìm: ");
                    int search = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] == search) {
                            System.out.println("Tìm thấy số tại vị trí thứ " + i);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy số cần tìm");
                    }
                    break;

                case 6: //
                    System.out.println("Thoát");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }  while (choice != 6);

        sc.close();
    }
}
