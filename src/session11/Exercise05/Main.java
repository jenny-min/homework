package session11.Exercise05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();

        while (true) {
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            String name = scanner.nextLine();

            // kiểm tra rỗng
            if (name.trim().isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            // nhập startDate
            LocalDateTime startDate = inputDate("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm): ");

            // nhập endDate
            LocalDateTime endDate = inputDate("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm): ");

            // check logic thời gian
            if (endDate.isBefore(startDate)) {
                System.out.println("End date must be after start date!");
                continue;
            }

            events.add(new Event(name, startDate, endDate));
        }

        // in danh sách
        System.out.println("Danh sách sự kiện:");
        for (Event e : events) {
            System.out.println(e);
        }
    }

    // hàm nhập ngày (fix lỗi chính ở đây)
    public static LocalDateTime inputDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();

                return LocalDateTime.parse(input, formatter);

            } catch (DateTimeParseException e) {
                System.out.println("Enter not valid date");
            }
        }
    }
}
