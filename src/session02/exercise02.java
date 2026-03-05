package session02;

import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args){
        //Tạo đối tượng để người dùng nhập vào giá trị
        Scanner sc = new Scanner(System.in);

        //Yêu cầu người dùng nhập một số nguyên từ 1 đến 7
        System.out.println("Hãy nhập một số nguyên từ 1 đến 7: ");
        int n = sc.nextInt();

        //Sử dụng switch case
        switch (n) {
            case 1:
                System.out.print("Chủ nhật");
                break;

            case 2:
                System.out.println("Thứ Hai");
                break;

            case 3:
                System.out.println("Thứ Ba");
                break;

            case 4:
                System.out.println("Thứ Tư");
                break;

            case 5:
                System.out.println("Thứ Năm");
                break;

            case 6:
                System.out.println("Thứ Sáu");
                break;
            case 7:
                System.out.println("Thứ Bảy");
                break;
            default:
                System.out.println("Số nhập vào không hợp lệ");
                break;
        }

        //đóng scanner
        sc.close();
    }
}
