package session10.Exercise04;

import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui lòng không để trống");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getInt(Scanner scanner, String suggest) {
        String result = "";
        do {
            System.out.println(suggest);
            result = scanner.nextLine();

            try {
                if (result.isEmpty()){
                    System.out.println("Vui lòng không để trống!");
                } else if (Integer.parseInt(result) < 0) {
                    System.out.println("Vui lòng nhập số nguyên >=0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên >= 0!");
            }
        } while (true);
        return Integer.parseInt(result);
    }
}
