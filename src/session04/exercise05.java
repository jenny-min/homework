package session04;

import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập kích thước của mảng
        System.out.print("Nhập số hàng: ");
        int rows = sc.nextInt();

        System.out.println("Nhập số cột: ");
        int cols = sc.nextInt();

        //Khởi tạo màng
        int[][] arr = new int[rows][cols];

        // Nhập giá trị cho mảng
        System.out.println("Nhập các phần tử cho mảng (theo từng hàng):");
        for (int i = 0; i < rows; i++) {
            System.out.print("Hàng " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Khai báo biến tính tổng
        int sumEven = 0;
        int sumOdd = 0;

        // Duyệt mảng để tính tổng
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] % 2 == 0) {
                    sumEven += arr[i][j];
                } else {
                    sumOdd += arr[i][j];
                }
            }
        }

        //Hiển thị
        System.out.println("Tổng các số chẵn là: " + sumEven);
        System.out.println("Tổng các số lẻ là: " + sumOdd);
        sc.close();
    }
}
