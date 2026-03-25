package session09.Exercise03.ra.presentetion;

import session09.Exercise03.ra.entity.*;
import session09.Exercise03.ra.entity.Categories;
import session09.Exercise03.ra.entity.Product;
import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Categories[] arrC = new Categories[100];
        Product[] arrP = new Product[100];

        int indexC = 0;
        int indexP = 0;

        while (true) {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // CATEGORIES MENU
                    while (true) {
                        System.out.println("********CATEGORIES MENU********");
                        System.out.println("1. Nhập thông tin các danh mục");
                        System.out.println("2. Hiển thị thông tin các danh mục");
                        System.out.println("3. Cập nhật thông tin danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Cập nhật trạng thái danh mục");
                        System.out.println("6. Thoát");

                        int c = Integer.parseInt(sc.nextLine());

                        switch (c) {
                            case 1://Thêm
                                System.out.print("Nhập số lượng danh mục: ");
                                int n = Integer.parseInt(sc.nextLine());
                                for (int i = 0; i < n; i++) {
                                    System.out.println("Nhập danh mục thứ " +(i + 1)+ ": ");
                                    arrC[indexC] = new Categories();
                                    arrC[indexC].inputData(sc, arrC, indexC);
                                    indexC++;
                                }
                                break;

                            case 2://Hiển thị
                                for (int i = 0; i < indexC; i++) {
                                    arrC[i].displayData();
                                }
                                break;

                            case 3://Cập nhật theo mã
                                System.out.print("Nhập mã danh mục muốn cập nhật: ");
                                int id = Integer.parseInt(sc.nextLine());
                                for (int i = 0; i < indexC; i++) {
                                    if (arrC[i].getCatalogId() == id) {
                                        arrC[i].inputData(sc, arrC, i);
                                    }
                                }
                                break;

                            case 4://Xóa
                                System.out.print("Nhập mã danh mục cần xóa: ");
                                int delId = Integer.parseInt(sc.nextLine());

                                boolean hasProduct = false;
                                for (int i = 0; i < indexP; i++) {
                                    if (arrP[i].getCatalogId() == delId) {
                                        hasProduct = true;
                                        break;
                                    }
                                }

                                if (!hasProduct) {
                                    for (int i = 0; i < indexC; i++) {
                                        if (arrC[i].getCatalogId() == delId) {
                                            for (int j = i; j < indexC - 1; j++) {
                                                arrC[j] = arrC[j + 1];
                                            }
                                            indexC--;
                                            System.out.println("Đã được xóa");
                                            break;
                                        }

                                    }
                                } else {
                                    System.out.println("Không thể xóa danh mục chứa sản phẩm");
                                }
                                break;

                            case 5://cập nhật theo tên
                                System.out.print("Nhập mã danh mục cần cập nhật: ");
                                int id2 = Integer.parseInt(sc.nextLine());
                                for (int i = 0; i < indexC; i++) {
                                    if (arrC[i].getCatalogId() == id2) {
                                        arrC[i].setCatalogStatus(!true);
                                    }
                                }
                                break;

                            case 6:
                                break;
                        }
                        if (c == 6) break;
                    }
                    break;

                case 2:
                    // PRODUCT MENU
                    while (true) {
                        System.out.println("********PRODUCT MENU********");
                        System.out.println("1. Nhập thông tin các sản phẩm");
                        System.out.println("2. Hiển thị thông tin các sản phẩm");
                        System.out.println("3. Sắp xếp các sản phẩm theo giá");
                        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                        System.out.println("5. Xóa mã sản phẩm theo mã sản phẩm");
                        System.out.println("6. Tìm kiểm các sản phẩm theo tên sản phẩm");
                        System.out.println("7. Tìm kiểm sản phẩm trong khoảng giá a - b (a, b nhập từ bàn phím)");
                        System.out.println("8. Thoát");

                        int p = Integer.parseInt(sc.nextLine());

                        switch (p) {
                            case 1://Thêm
                                arrP[indexP] = new Product();
                                arrP[indexP].inputData(sc, arrP, indexP, arrC, indexC);
                                indexP++;
                                break;

                            case 2://Hiển thị
                                for (int i = 0; i < indexP; i++) {
                                    arrP[i].displayData();
                                }
                                break;

                            case 3://Sắp xếp
                                for (int i = 0; i < indexP - 1; i++) {
                                    for (int j = i + 1; j < indexP; j++) {
                                        if (arrP[i].getPrice() > arrP[j].getPrice()) {
                                            Product temp = arrP[i];
                                            arrP[i] = arrP[j];
                                            arrP[j] = temp;
                                        }
                                    }
                                }
                                break;

                            case 4:
                                System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                                String updateId = sc.nextLine();

                                boolean foundUpdate = false;

                                for (int i = 0; i < indexP; i++) {
                                    if (arrP[i].getProductId().equals(updateId)) {
                                        foundUpdate = true;

                                        System.out.println("Nhập lại thông tin (không đổi ID)");

                                        // Name
                                        while (true) {
                                            System.out.print("Tên mới: ");
                                            String name = sc.nextLine();
                                            if (name.length() >= 10 && name.length() <= 50) {
                                                arrP[i].setProductName(name);
                                                break;
                                            }
                                            System.out.println("Tên không hợp lệ!");
                                        }

                                        // Price
                                        while (true) {
                                            System.out.print("Giá mới: ");
                                            try {
                                                float price = Float.parseFloat(sc.nextLine());
                                                if (price > 0) {
                                                    arrP[i].setPrice(price);
                                                    break;
                                                }
                                            } catch (Exception e) {}
                                            System.out.println("Giá sai!");
                                        }

                                        // Description
                                        System.out.print("Mô tả mới: ");
                                        arrP[i].setDescription(sc.nextLine());

                                        // Chọn lại danh mục
                                        System.out.println("Danh mục:");
                                        for (int j = 0; j < indexC; j++) {
                                            arrC[j].displayData();
                                        }

                                        while (true) {
                                            System.out.print("Chọn catalogId: ");
                                            int catId = Integer.parseInt(sc.nextLine());

                                            boolean exist = false;
                                            for (int j = 0; j < indexC; j++) {
                                                if (arrC[j].getCatalogId() == catId) {
                                                    exist = true;
                                                    break;
                                                }
                                            }

                                            if (exist) {
                                                arrP[i].setCatalogId(catId);
                                                break;
                                            }
                                            System.out.println("Không tồn tại!");
                                        }

                                        // Status
                                        while (true) {
                                            System.out.print("Trạng thái (0/1/2): ");
                                            int st = Integer.parseInt(sc.nextLine());
                                            if (st >= 0 && st <= 2) {
                                                arrP[i].setProductStatus(st);
                                                break;
                                            }
                                        }

                                        System.out.println("Cập nhật thành công!");
                                        break;
                                    }
                                }

                                if (!foundUpdate) {
                                    System.out.println("Không tìm thấy sản phẩm!");
                                }
                                break;

                            case 6:
                                System.out.print("Nhập tên sản phẩm: ");
                                String name = sc.nextLine();
                                for (int i = 0; i < indexP; i++) {
                                    if (arrP[i].getProductName().contains(name)) {
                                        arrP[i].displayData();
                                    }
                                }
                                break;

                            case 7:
                                System.out.print("Khoảng giá a: ");
                                float a = Float.parseFloat(sc.nextLine());
                                System.out.print("Khoảng giá b: ");
                                float b = Float.parseFloat(sc.nextLine());

                                for (int i = 0; i < indexP; i++) {
                                    if (arrP[i].getPrice() >= a && arrP[i].getPrice() <= b) {
                                        arrP[i].displayData();
                                    }
                                }
                                break;

                            case 8:
                                break;
                        }
                        if (p == 8) break;
                    }
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}
