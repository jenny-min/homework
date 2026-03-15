package session06;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        //Tạo đối tượng nhập
        Scanner sc = new Scanner(System.in);
        //Biến choice
        int choice;
        //Mảng lưu điểm
        double[] scores = new double[0];

        //Menu
        do {
            System.out.println("******************QUẢN LÝ ĐIỂM SV****************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.println("*************************************************");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                    //1. Nhập điểm sinh viên
                case 1:
                    System.out.println("Nhập số sinh viên: ");
                    int n = sc.nextInt();
                    scores = new double[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                        scores[i] = sc.nextDouble();
                    }
                    break;

                    //2. In danh sách điểm
                case 2:
                    if (scores.length == 0) {
                        System.out.println("Danh sách điểm rỗng");
                        break;
                    }

                    System.out.println("Danh sách điểm sinh viên: ");
                    for (int i = 0; i < scores.length; i++) {
                        System.out.println("Sinh viên " + (i + 1) + ": " + scores[i]);
                    }
                    break;

                    //3. Tính điểm trung bình
                case 3:
                    if (scores.length == 0) {
                        System.out.println("Danh sách điểm rỗng!");
                        break;
                    }

                    double sum = 0;
                    for (double s : scores) {
                        sum += s;
                    }
                    double avg = sum / scores.length;
                    System.out.println("Điểm trung bình: " + avg);
                    break;

                    //4. Tìm điểm cao và thấp nhất
                case 4:
                    if (scores.length == 0) {
                        System.out.println("Danh sách điểm rỗng!");
                        break;
                    }

                    double max = scores[0];
                    double min = scores[0];
                    for (double s : scores) {
                        if (s > max) max = s;
                        if (s < min) min = s;
                    }
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    break;

                    //5. Đếm số lượng sinh viên trượt và đạt
                case 5:
                    if (scores.length == 0) {
                        System.out.println("Danh sách điểm rỗng!");
                        break;
                    }

                    int pass = 0;
                    int fail = 0;
                    for (double s : scores) {
                        if (s >= 5) {
                            pass++;
                        } else {
                            fail++;
                        }
                    }

                    System.out.println("Số sinh viên đạt: " + pass);
                    System.out.println("Số sinh viên trượt: " + fail);
                    break;

                    //6. Sắp xếp điểm tăng dần
                case 6:
                    if (scores.length == 0) {
                        System.out.println("Danh sách điểm rỗng!");
                        break;
                    }

                    Arrays.sort(scores);
                    System.out.println("Danh sách điểm sau khi sắp xếp: ");
                    for (double s : scores) {
                        System.out.println(s);
                    }
                    break;

                    //7. Thống kê số lượng sinh viên giỏi và xuất sắc
                case 7:
                    int excellent = 0;
                    for (double s : scores) {
                        if (s >= 8) {
                            excellent++;
                        }
                    }
                    System.out.println("Số sinh viên giỏi và xuất sắc: " + excellent);
                    break;

                    //8. Thoát
                case 8:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
            }
        } while (choice != 8);

        //Đóng scanner
        sc.close();
    }
}
