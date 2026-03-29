package session11.Exercise01;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Tạo danh sách số nguyên
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Sử dụng Lambda Expression để in ra tất cả các số chẵn trong danh sách
        System.out.println("Các số chẵn trong danh sách: ");
        //Duyệt qua mảng
        numbers.forEach(number -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        });

        //Sử dụng Lambda Expression để tính tổng của tất cả các số trong danh sách
        //tạo biến sum chứa tổng
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Tổng của tất cả các số trong danh sách: " + sum);
    }
}
