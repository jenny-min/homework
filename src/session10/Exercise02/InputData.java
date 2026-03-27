package session10.Exercise02;

import java.util.Scanner;

public class InputData {
    //test nhập tên sách và tác giả
    public static String getString(Scanner scanner, String suggest) {
        String input = "";

        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui lòng không để trống!");
            }
        } while (input.isEmpty());
        return input;
    }

    //test nhập năm
    public static int getInt(Scanner scanner, String suggest) {
        String result = "";
        do {
            System.out.println(suggest);
            result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println("Vui lòng không để trống!");
            } else if (Integer.parseInt(result) < 0) {
                System.out.println("Vui lòng nhập số nguyên >= 0!");
            } else {
                break;
            }
        } while (true);
        return Integer.parseInt(result);
    }
}
