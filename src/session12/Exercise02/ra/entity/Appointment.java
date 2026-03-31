package session12.Exercise02.ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Appointment() {}

    public Appointment(String appointmentId, String patientName, String phoneNumber,
                       LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    // Getter
    public String getAppointmentId() { return appointmentId; }
    public String getPatientName() { return patientName; }
    public String getPhoneNumber() { return phoneNumber; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public String getDoctor() { return doctor; }

    // Setter
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    //Input Data
    public void inputData(Scanner scanner, List<Appointment> list) {

        // ID (6 ký tự, không trùng)
        while (true) {
            System.out.print("Nhập ID (6 ký tự): ");
            String id = scanner.nextLine().trim();

            if (id.length() != 6) {
                System.out.println("Phải đúng 6 ký tự!");
                continue;
            }

            boolean exist = list.stream()
                    .anyMatch(a -> a.getAppointmentId().equalsIgnoreCase(id));

            if (exist) {
                System.out.println("ID đã tồn tại!");
                continue;
            }

            this.appointmentId = id;
            break;
        }

        //Tên
        while (true) {
            System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
            String name = scanner.nextLine().trim();

            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên không hợp lệ! Tên phải có (10-50 ký tự)");
                continue;
            }

            this.patientName = name;
            break;
        }

        //SĐT Việt Nam
        while (true) {
            System.out.print("Nhập SĐT: ");
            String phone = scanner.nextLine();

            if (!phone.matches("^(03|05|07|08|09)\\d{8}$")) {
                System.out.println("Sai định dạng! Vui lòng nhập đúng định dạng!");
                continue;
            }

            this.phoneNumber = phone;
            break;
        }

        //Ngày
        while (true) {
            try {
                System.out.print("Nhập ngày (dd/MM/yyyy): ");
                this.appointmentDate = LocalDate.parse(scanner.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Sai định dạng!");
            }
        }

        //Bác sĩ
        while (true) {
            System.out.print("Nhập bác sĩ phụ trách: ");
            String doc = scanner.nextLine();

            if (doc.length() > 200) {
                System.out.println("Tên bác sĩ phải <200 ký tự!");
                continue;
            }

            this.doctor = doc;
            break;
        }
    }

    @Override
    public String toString() {
        return "ID lịch hẹn: " + appointmentId + " | Tên bệnh nhân: " + patientName + " | Số điện thoại" + phoneNumber +
                " | Lịch hẹn: " + appointmentDate.format(formatter) + " | Bác sĩ phụ trách: " + doctor;
    }
}
