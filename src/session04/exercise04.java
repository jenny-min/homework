package session04;

import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập kích thước của mảng
        System.out.print("Nhập kích thước của mảng: ");
        int size = sc.nextInt();

        // Kiểm tra kích thước mảng
        if (size <= 0) {
            System.out.println("Kích thước rỗng");
            return;
        }

        int[] array = new int[size];

        // Nhập giá trị cho từng phần tử của mảng
        System.out.println("Nhập các giá trị cho mảng:");
        for (int i = 0; i < size; i++) {
            System.out.print("Giá trị thứ " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        // Hiển thị mảng ban đầu
        System.out.print("Mảng ban đầu: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        // Đảo ngược mảng
        for (int i = 0; i < size / 2; i++) {
            // Hoán đổi phần tử
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }

        // Hiển thị mảng sau khi đảo ngược
        System.out.print("\nMảng sau khi đảo ngược: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
