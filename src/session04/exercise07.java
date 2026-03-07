package session04;

import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phần tử
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        //Nếu mảng rỗng thì báo mảng không hợp lệ
        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        //Khởi tạo mảng
        int[] arr = new int[n];

        // Nhập các phần tử
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = new int[n];
        int countUnique = 0;

        // Kiểm tra tần suất xuất hiện
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            // Nếu xuất hiện đúng 1 lần
            if (count == 1) {
                result[countUnique] = arr[i];
                countUnique++;
            }
        }

        // In kết quả
        if (countUnique == 0) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
        } else {
            System.out.println("Mảng sau khi loại bỏ phần tử trùng lặp: ");
            for (int i = 0; i < countUnique; i++) {
                System.out.print(result[i] + " ");
            }
        }

        sc.close();
    }
}
