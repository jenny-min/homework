package session11.Exercise09;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //User
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        // Task
        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        LocalDate today = LocalDate.now();

        // 1. Công việc quá hạn & chưa hoàn thành
        System.out.println("=== Công việc quá hạn & chưa hoàn thành ===");
        tasks.stream()
                .filter(t -> !t.isCompleted())
                .filter(t -> t.getDueDate().isBefore(today))
                .forEach(t -> System.out.println(t.display()));

        // 2. Đếm số công việc đã hoàn thành
        long completedCount = tasks.stream()
                .filter(Task::isCompleted)
                .count();

        System.out.println("\nSố công việc đã hoàn thành: " + completedCount);

        // 3. In danh sách user
        System.out.println("\n=== Danh sách người dùng ===");
        List<User> users = List.of(u1, u2, u3);

        users.forEach(u -> System.out.println(u.display()));
    }
}
