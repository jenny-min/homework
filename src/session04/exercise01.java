package session04;

import java.util.Scanner;

public class exercise01 {
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

        //Sắp xếp mảng bằng Selection Sort
        selectionSort(arr);

        //Hiển thị mảng đã sắp xếp
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần: ");
        for (int value : arr) System.out.print(value + " ");

        //Phần tử lớn nhất
        System.out.println("\nPhần tử lớn nhất trong mảng là: " + arr[0]);


    }


    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            //Hoán đổi vị trí
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}


