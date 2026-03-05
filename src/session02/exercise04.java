package session02;

import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args){
        //Tạo đối tượng và khai báo biến age
        Scanner sc = new Scanner(System.in);
        int age = 0;

        //dùng do while
        do {
            //Yêu cầu người dùng nhập tuổi
            System.out.println("Vui lòng nhập tuổi của bạn:");

            //Kiểm trả dữ liệu nhập vào có phải là số nguyên dương?
            if (sc.hasNextInt()) {
                age = sc.nextInt();

                if (age <= 0) {
                    System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0");
                }
            } else {
                System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0");
                sc.next();
            }

        }while (age <= 0);

        //Hiển thị tuổi
        System.out.printf("Tuổi của bạn là %d.", age);

        //Đóng scanner
        sc.close();
    }
}
