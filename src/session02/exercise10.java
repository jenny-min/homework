package session02;

import java.util.Scanner;

public class exercise10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;

        // Kiểm tra nhập đúng số nguyên dương
        while (true) {
            System.out.print("Nhập số nguyên dương: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Số nhập vào không hợp lệ");
        }

        System.out.println("Các số Happy từ 1 đến " + n + " là:");

        for (int i = 1; i <= n; i++) {
            if (isHappy(i)) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }

    // Hàm tính tổng bình phương các chữ số
    public static int sumSquareDigits(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    // Hàm kiểm tra số Happy
    public static boolean isHappy(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = sumSquareDigits(slow);
            fast = sumSquareDigits(sumSquareDigits(fast));
        } while (slow != fast);

        return slow == 1;
    }
}