package session02;

import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args){
        //Tạo đối tượng để người dùng nhập vào giá trị
        Scanner sc = new Scanner(System.in);

        //yêu cầu người dùng nhập vào số nguyên
        System.out.print("Vui lòng nhập vào 1 số nguyên: ");
        int n = sc.nextInt();

        //Kiểm tra có phải số chẵn hay không
        if (n == 0) {
            System.out.print("Số không phải chẵn cũng không phải lẻ");
        } else if (n%2 == 0) {
            System.out.printf("Số %d là số chẵn", n);
        } else {
            System.out.printf("Số %d là số lẻ", n);
        }

        //Đóng scanner
        sc.close();
    }
}
