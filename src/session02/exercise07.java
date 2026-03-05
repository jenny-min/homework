package session02;

import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) {
        //Tạo đối tượng để người dùng nhập vào
        Scanner sc = new Scanner(System.in);

        //Yêu cầu người dùng nhập vào 3 số nguyên, ứng với 3 cạnh bất kì
        System.out.println("Hãy nhập vào cạnh 1: ");
        int a = sc.nextInt();
        System.out.println("Hãy nhập vào cạnh 2: ");
        int b = sc.nextInt();
        System.out.println("Hãy nhập vào cạnh 3: ");
        int c = sc.nextInt();

        // Kiểm tra điều kiện tạo thành tam giác và phân loại tam giác
        if (a + b > c && a + c > b && b + c >a) {
            //Tam giác đều
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều.");
            }
            //Tam giác cân
            else if (a == b || b == c || a == c) {
                System.out.println("Đây là tam giác cân.");
            }
            //Tam giác vuông
            else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a){
                System.out.println("Đây là tam giác vuông.");
            }
            //Không thuộc 3 loại trên
            else {
                System.out.println("Đây là tam giác thường.");
            }
        }else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }
    }
}
