package session05;

import java.util.Scanner;

/*Thuật toán RLE hoạt động bằng cách đếm số lần ký tự xuất hiện liên tiếp và ghi lại ký tự đó cùng với số lần xuất hiện*/

public class Exercise08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String inputStr = sc.nextLine();

        //Chuỗi rỗng
        if (inputStr.isEmpty()) {
            System.out.println(" ");
            return;
        }

        //Dùng StringBuilder để nối chuỗi nhanh và đỡ tốn bộ nhớ
        StringBuilder resultStr = new StringBuilder();

        //Biến count để đếm số lần ký tự xuất hiện
        int count = 1;

        //Duyệt từ trái sang phải
        //Nếu ký tự hiện tại giống với ký tự trước đó - > tăng count
        //Nếu k -> thêm ký tự + count vào resultStr và set count = 1
        for (int i = 1; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == inputStr.charAt(i - 1)) {
                count++;
            } else {
                resultStr.append(inputStr.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        //Thêm lý tự cuối
        resultStr.append(inputStr.charAt(inputStr.length() -1 )).append(count);
        //Hiển thị
        System.out.println("Chuỗi sau khi nén: " + resultStr);
    }
}
