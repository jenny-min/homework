package session12.Exercise02.ra.business;

import session12.Exercise02.ra.entity.Appointment;

import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    private List<Appointment> list = new ArrayList<>();

    // thêm
    public void add(Scanner sc) {
        Appointment a = new Appointment();
        a.inputData(sc, list);
        list.add(a);
        System.out.println("Thêm thành công!");
    }

    // hiển thị (sort theo ngày)
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        list.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    // tìm theo tên
    public void search(Scanner sc) {
        System.out.print("Nhập tên: ");
        String keyword = sc.nextLine().toLowerCase();

        List<Appointment> result = list.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(keyword))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            result.forEach(System.out::println);
        }
    }

    // update (Optional)
    public void update(Scanner sc) {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        Optional<Appointment> opt = list.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id))
                .findFirst();

        opt.ifPresentOrElse(a -> {
            System.out.println("Nhập lại thông tin:");
            a.inputData(sc, list);
            System.out.println("Cập nhật thành công!");
        }, () -> System.out.println("Không tìm thấy!"));
    }

    // delete
    public void delete(Scanner sc) {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        Optional<Appointment> opt = list.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id))
                .findFirst();

        opt.ifPresentOrElse(a -> {
            System.out.print("Xác nhận xóa (Y/N): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                list.remove(a);
                System.out.println("Đã xóa!");
            }
        }, () -> System.out.println("Không tìm thấy!"));
    }

    // thống kê
    public void statistics() {
        System.out.println("Tổng số lịch: " + list.size());

        Map<String, Long> stats = list.stream()
                .collect(Collectors.groupingBy(
                        Appointment::getDoctor,
                        Collectors.counting()
                ));

        stats.forEach((doc, count) ->
                System.out.println(doc + ": " + count));
    }
}
