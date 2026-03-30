package session11.Exercise03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatApp {
    private List<Message> messages;

    public ChatApp() {
        messages = new ArrayList<>();
    }

    // Gửi tin nhắn
    public void sendMessage(String sender, String content) {
        messages.add(new Message(sender, content));
    }

    // Hiển thị tất cả tin nhắn
    public void showAllMessages() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào.");
            return;
        }
        messages.forEach(Message::display);
    }

    // Lọc theo người gửi (Stream)
    public void filterBySender(String sender) {
        List<Message> result = messages.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(sender))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn.");
        } else {
            result.forEach(Message::display);
        }
    }

    // Lọc theo ngày (Stream)
    public void filterByDate(LocalDate date) {
        List<Message> result = messages.stream()
                .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không có tin nhắn trong ngày này.");
        } else {
            result.forEach(Message::display);
        }
    }
}