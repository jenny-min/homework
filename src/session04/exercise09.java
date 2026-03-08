package session04;

import java.util.Scanner;

public class exercise09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập kích thước mảng
        System.out.println("Nhập vào kích thước của mảng: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        //Khởi tạo mảng
        int[] arr = new int[n];

        //Nhập các giá trị của mảng
        System.out.println("Nhập các giá trị của mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //Tạo biến tạm
        int currentSum = 0;//tổng tạm thời của dãy con đang xét
        int maxSum = arr[0];//tổng lớn nhất tìm được

        int start = 0;
        int end = 0;
        int tempStart = 0;//biến tạm chứa phần tử bắt đầu

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];//Cộng phần tử hiện tại vào currentSum

            //Nếu currentSum > maxSum -> cập nhập lại maxSum = currentSum
            if (currentSum > maxSum) {
                 maxSum = currentSum;
                 start = tempStart;
                 end = i;
            }

            //Nếu currentSum < 0 -> đặt lại currentSum = 0
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        //Hiển thị
        System.out.println( "Tổng lớn nhất là: " + maxSum);
        System.out.print("Dãy con có tổng lớn nhất: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
