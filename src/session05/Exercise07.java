package session05;

import java.util.Scanner;
import java.util.Random;

public class Exercise07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Nhập độ dài chuỗi: ");
        int n = sc.nextInt();

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        System.out.println("Chuỗi ngẫu nhiên: " + result.toString());
    }
}
