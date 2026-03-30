package session11.Exercise03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatApp manager = new ChatApp();

        while (true) {
            System.out.print("Nhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = scanner.nextLine();

            if (sender.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Nhập nội dung tin nhắn:");
            String content = scanner.nextLine();

            manager.sendMessage(sender, content);

            System.out.println("Nhập 'history' để xem lịch sử, hoặc 'filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày:");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "history":
                    System.out.println("Lịch sử chat:");
                    manager.showAllMessages();
                    break;

                case "filter":
                    System.out.print("Nhập tên người gửi để lọc: ");
                    String name = scanner.nextLine();
                    System.out.println("Tin nhắn từ " + name + ":");
                    manager.filterBySender(name);
                    break;

                case "date":
                    try {
                        System.out.print("Nhập ngày (dd-MM-yyyy): ");
                        String input = scanner.nextLine();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate date = LocalDate.parse(input, formatter);

                        System.out.println("Tin nhắn trong ngày " + date + ":");
                        manager.filterByDate(date);

                    } catch (Exception e) {
                        System.out.println("Sai định dạng ngày!");
                    }
                    break;

                default:
                    System.out.println("Lệnh không hợp lệ!");
            }
        }
    }
}