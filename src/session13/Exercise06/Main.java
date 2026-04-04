package session13.Exercise06;

import session13.Exercise06.business.model.Task;
import session13.Exercise06.business.service.TaskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final TaskManagement taskService = new TaskManagement();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("\n*** QUẢN LÝ TO-DO-LIST ***");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Liệt kê công việc");
            System.out.println("3. Cập nhật trạng thái công việc");
            System.out.println("4. Xóa công việc");
            System.out.println("5. Tìm kiếm công việc");
            System.out.println("6. Thống kê công việc");
            System.out.println("7. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: //Thêm công việc
                        handleAddTask();
                        break;
                    case 2: //Liệt kê danh sách
                        showTaskList();
                        break;
                    case 3: //Cập nhật trạng thái
                        handleUpdateTask();
                        break;
                    case 4: //Xóa
                        handleDeleteTask();
                        break;
                    case 5: // Tìm kiếm
                        handleSearchTask();
                        break;
                    case 6: //Thống kê
                        taskService.taskStatistics();
                        break;
                    case 7: //Thoát
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
                }

            } catch (NumberFormatException e) {
                System.err.println("Lỗi! Vui lòng nhập số nguyên!");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        } while (true);
    }

    private static void showTaskList(){
        List<Task> tasks = taskService.taskList();
        if (tasks.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.printf("%-5s | %-30s | %-20s\n", "ID", "Tên công việc", "Trạng thái");
            for (Task t : tasks) {
                System.out.printf("%-5d | %-30s | %-20s\n", t.getId(), t.getTaskName(), t.getStatus());
            }
        }
    }

    private static void handleAddTask() {
        System.out.println("Nhập tên công việc: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.err.println("Tên công việc không được để trống!");
            return;
        }

        System.out.println("Chọn trạng thái: 1. Chưa hoàn thành | 2. Đã hoàn thành");
        String status = scanner.nextLine().equals("2") ? "Đã hoàn thành" : "Chưa hoàn thành";

        Task newTask = new Task(0, name, status);
        taskService.addTask(newTask);
    }

    private static void handleUpdateTask() {
        System.out.print("Nhập ID công việc cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Trạng thái mới: 1. Chưa hoàn thành | 2. Đã hoàn thành");
        String status = scanner.nextLine().equals("2") ? "Đã hoàn thành" : "Chưa hoàn thành";

        Task updateTask = new Task(id, null, status);
        taskService.updateTaskStatus(updateTask);
    }

    private static void handleDeleteTask() {
        System.out.println("Nhập ID công việc cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            taskService.deleteTask(id);
        }
    }

    private static void handleSearchTask() {
        System.out.print("Nhập từ khóa tên công việc cần tìm: ");
        String keyword = scanner.nextLine().trim();
        if (keyword.isEmpty()) {
            System.err.println("Vui lòng nhập từ khóa!");
            return;
        }
        taskService.searchTaskByName(keyword);
    }
}
