package session10.Exercise10;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên (1 - 3999): ");
        int n = scanner.nextInt();

        if (n < 1 || n > 3999) {
            System.out.println("Số không hợp lệ!");
            return;
        }

        // Dùng LinkedHashMap để giữ thứ tự từ lớn -> nhỏ
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");//đặc biệt
        romanMap.put(500, "D");
        romanMap.put(400, "CD");//đặc biệt
        romanMap.put(100, "C");
        romanMap.put(90, "XC");//đặc biệt
        romanMap.put(50, "L");
        romanMap.put(40, "XL");//đặc biệt
        romanMap.put(10, "X");
        romanMap.put(9, "IX");//đặc biệt
        romanMap.put(5, "V");
        romanMap.put(4, "IV");//Đặc biệt
        romanMap.put(1, "I");

        StringBuilder result = new StringBuilder();

        // Duyệt Map
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            while (n >= value) {
                result.append(symbol);
                n -= value;
            }
        }

        System.out.println("Số La Mã: " + result);
    }
}
