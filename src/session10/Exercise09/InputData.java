package session10.Exercise09;

import java.util.Scanner;

public interface InputData {
    default String inputString(Scanner scanner, String suggest) {
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
    default int inputInt(Scanner scanner, String suggest) {
        String result = "";
        do {
            System.out.println(suggest);
            result = scanner.nextLine();
            try {
                if (result.isEmpty()) {
                    System.out.println("Vui lòng ko để trống!");
                } else if (Integer.parseInt(result) < 0) {
                    System.out.println("Vui lòng nhập số nguyên >= 0");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên >= 0");
            }
        } while (true);
        return Integer.parseInt(result);
    }
    default double inputDouble(Scanner scanner, String suggest) {
        String result = "";
        do {
            System.out.println(suggest);
            result = scanner.nextLine();
            try {
                if (result.isEmpty()) {
                    System.out.println("Vui lòng ko để trống!");
                } else if (Double.parseDouble(result) < 0) {
                    System.out.println("Vui lòng nhập số thực >= 0!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số thực >= 0!");
            }
        } while (true);
        return Double.parseDouble(result);
    }
}
