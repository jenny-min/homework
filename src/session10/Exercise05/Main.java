package session10.Exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceManager invoiceManager = new InvoiceManager();
        int currentId = 1;
        int choice;

        while (true) {
            System.out.println("********** MENU QUẢN LÝ HÓA ĐƠN **********");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");

            try {
                choice = Integer.parseInt(InputData.getString(scanner, "Lựa chọn của bạn: "));

                switch (choice) {
                    case 1://Thêm
                        String invoiceCode = InputData.getString(scanner, "Nhập mã hóa đơn:");
                        double amount = InputData.getDouble(scanner, "Nhập số tiền: ");
                        Invoice invoice = new Invoice(currentId++, invoiceCode, (float) amount);
                        invoiceManager.add(invoice);
                        System.out.println("Hóa đơn đã được thêm thành công!");
                        break;
                    case 2://Sửa
                        if (invoiceManager.isEmpty()) {
                            System.out.println("Danh sách hóa đơn trống");
                        }
                        invoiceManager.display();
                        int update = InputData.getInt(scanner, "Nhập id hóa đơn cần sửa: ");
                        int index = -1;
                        for (int i = 0; i < invoiceManager.invoices.size(); i++) {
                            if (invoiceManager.invoices.get(i).getId() == update) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {
                            System.out.println("Không tìm thấy hóa đơn có id = " + update);
                        } else {
                            String newInvoiceCode = InputData.getString(scanner, "Nhập mã hóa đơn mới: ");
                            double newAmount = InputData.getDouble(scanner, "Nhập số tiền mới: ");
                            invoiceManager.update(index, new Invoice(update, newInvoiceCode, (float) newAmount));
                        }
                        break;
                    case 3://Xóa
                        if (invoiceManager.isEmpty()) {
                            System.out.println("Danh sách hóa đơn trống");
                        }
                        invoiceManager.display();
                        int delete = InputData.getInt(scanner, "Nhập id hóa đơn cần xóa: ");
                        int indexDelete = -1;
                        for (int i = 0; i < invoiceManager.invoices.size(); i++) {
                            if (invoiceManager.invoices.get(i).getId() == delete) {
                                indexDelete = 1;
                                break;
                            }
                        }
                        if (indexDelete == -1) {
                            System.out.println("Không tìm thấy hóa đơn nào có id = " + delete);
                        } else {
                            invoiceManager.delete(indexDelete);
                            System.out.println("Hóa đơn đã được xóa thành công!");
                        }
                        break;
                    case 4://Hiển thị
                        invoiceManager.display();
                        break;
                    case 5://Thoát
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
            }
        }
    }
}
