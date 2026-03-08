package session04;

import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập kích thước ma trận
        System.out.println("Nhập kích thước ma trận: ");
        int n = sc.nextInt();

        //Kiểm tra ma trận
        if (n <= 0 ) {
            System.out.println("Ma trận không hợp lệ");
        }

        //Khởi tạo mảng chứa ma trận
        int[][] matrix = new int[n][n];

        // Nhập ma trận
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Bước 1: Chuyển vị ma trận
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Bước 2: Đảo ngược các cột
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

        // In ma trận sau khi xoay
        System.out.println("Ma trận sau khi xoay 90 độ:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
