package session04;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Khởi tạo mảng
        System.out.println("Nhập kích thước mảng: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Nhập các giá trị cho mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Giá trị thử " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        //Sắp xếp mảng giảm dần theo thuật toán sắp xếp nổi bọt
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Hoán đổi
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có sự hoán đổi nào, mảng đã sắp xếp xong
            if (!swapped) break;
        }

        //Hiển thị
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần: ");
        for (int value : arr) System.out.print(value + " ");
    }
}
