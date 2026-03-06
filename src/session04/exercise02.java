package session04;

import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Khởi tạo mảng
        System.out.println("Nhập kích thước mảng: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < size ; i++) {
            System.out.println("Giá trị thứ " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        //Tính tổng
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        //Hiển thị
        System.out.println("Tổng các phần tử trong mảng: " + sum);
    }
}
