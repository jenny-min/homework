package session04;

import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập kích thước mảng
        System.out.println("Nhập kích thước cảu mảng: ");
        int size = sc.nextInt();

        //Khởi tạo mảng
        int[] arr = new int[size];

        //Nhập giá trị cho mảng
        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Giá trị thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // Sắp xếp chọn (giảm dần)
        for (int i = 0; i < size - 1; i++) {
            int maxIndex = i;//Gán giá trị lớn nhất cho số có chỉ số đầu tiên

            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // đổi chỗ
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        //Nhập số cần tìm
        System.out.println("Nhập số cần tìm: ");
        int number = sc.nextInt();//tạo biến là số cần tìm

        //Tìm kiếm tuyến tính - linear search
        int linearIndex = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == number) {
                linearIndex = i;
                break;
            }
        }

        //Tìm kiếm nhị phân - binary search
        int left = 0;
        int right = size - 1;
        int binaryIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == number) {
                binaryIndex = mid;
                break;
            } else if (arr[mid] < number) {
                right = mid - 1;  // vì mảng giảm dần
            } else {
                left = mid + 1;
            }
        }

        // Hiển thị mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        //Hiển thị kết quả tìm kiếm
        if (linearIndex != -1) {
            System.out.println("\nTìm kiếm tuyến tính: Phần tử " + number + " tìm thấy tại chỉ số " + linearIndex);
        } else {
            System.out.println("\nTìm kiếm tuyến tính: Không tìm thấy.");
        }

        if (binaryIndex != -1) {
            System.out.println("\nTìm kiếm nhin phân: Phần tử " + number + " tìm thấy tại chỉ số " + binaryIndex);
        } else {
            System.out.println("\nTìm kiếm nhị phân: Không tìm thấy.");
        }

        sc.close();

    }
}
