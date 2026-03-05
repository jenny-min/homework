package session03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        int choice;
        int count = 0;
        double sumSalary = 0;
        double maxSalary = -1;
        double minSalary = Double.MAX_VALUE;
        double totalBonus = 0;

        while (true) {
            System.out.println("\n***************MENU***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền lương nhân viên");
            System.out.println("4. Thoát");

            System.out.println("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: //Nhập lương nhân viên và phân loại lương
                    while (true) {
                        System.out.print("Nhập điểm học viên (-1 để kết thúc): ");
                        double salary = sc.nextDouble();

                        if (salary == -1) {
                            break;
                        }

                        if (salary < 0 || salary > 500000000) {
                            System.err.println("Lương không hợp lệ. Nhập lại.");
                            continue;
                        }
                        // Xếp loại
                        if (salary <= 5000000) {
                            System.out.println("-> Phân loại: Thấp");
                        } else if (salary <= 15000000) {
                            System.out.println("-> Phân loại: Trung bình");
                        } else if (salary <= 50000000) {
                            System.out.println("-> Phân loại: Khá");
                        } else {
                            System.out.println("-> Phân loại: Cao");
                        }

                        // Thống kê
                        count++;
                        sumSalary += salary;

                        if (salary > maxSalary) {
                            maxSalary = salary;
                        }

                        if (salary < minSalary) {
                            minSalary = salary;
                        }

                        // Tính thưởng
                        double bonus;

                        if (salary <= 5000000) {
                            bonus = salary * 0.05;
                        } else if (salary <= 15000000) {
                            bonus = salary * 0.10;
                        } else if (salary <= 50000000) {
                            bonus = salary * 0.15;
                        } else if (salary <= 100000000) {
                            bonus = salary * 0.20;
                        } else {
                            bonus = salary * 0.25;
                        }
//sửa
                        totalBonus += bonus;
                    }
                    break;
                case 2: //Thống kê
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {

                        double avg = sumSalary / count;

                        System.out.println("\n--- Thống kê ---");
                        System.out.println("Số nhân viên: " + count);
                        System.out.println("Tổng lương: " + df.format(sumSalary) + " VND");
                        System.out.println("Lương trung bình: " + df.format(avg) + " VND");
                        System.out.println("Lương cao nhất: " + df.format(maxSalary) + " VND");
                        System.out.println("Lương thấp nhất: " + df.format(minSalary) + " VND");
                    }
                    break;

                case 3: //Tính tổng tiền thưởng nhân viên
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("\n--- Tính tổng số tiền thưởng nhân viên ---");
                        System.out.println("Tổng tiền thưởng cho nhân viên: " + df.format(totalBonus) + " VND");
                    }
                    break;

                case 4: //Kết thúc chương trình
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
