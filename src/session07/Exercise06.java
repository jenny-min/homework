package session07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise06 {
    //Chuỗi lưu trữ
    private static List<Category> categoryList = new ArrayList<>();
    //Phương thức main
    public static void main(String[] args) {
        //Đối tượng nhập
        Scanner sc = new Scanner(System.in);
        //Biến choice
        int choice;
        boolean found = false;

        //Menu
        do {
            System.out.println("MENU:");
            System.out.println("1: Thêm mới danh mục");
            System.out.println("2: Hiển thị danh mục");
            System.out.println("3: Cập nhật danh mục");
            System.out.println("4: Xóa danh mục");
            System.out.println("5: Tìm kiếm danh mục theo tên");
            System.out.println("6: Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();


            //switch case
            switch (choice) {
                //Chức năng 1:Thêm mới danh mục
                case 1:
                    System.out.println("Nhập ID danh mục: ");
                    String id = sc.nextLine();
                    System.out.println("Nhập tên danh mục: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập mô tả danh mục: ");
                    String description = sc.nextLine();
                    categoryList.add(new Category(id, name, description));
                    System.out.println("Danh mục đã được thêm.");
                    break;

                //Chức năng 2: Hiển thị danh mục
                case 2:
                    if (categoryList.isEmpty()) {
                        System.out.println("Danh mục sản phẩm trống!");
                    }
                    System.out.println("Danh sách danh mục: ");
                    //for each
                    for (Category category : categoryList) {
                        System.out.println("ID: " + category.getCategoryId() + ", Tên: " + category.getCategoryName() + ", Mô tả: " + category.getDescription());
                    }
                    break;

                //Chức năng 3: Cập nhật sản phẩm
                case 3:
                    System.out.println("Nhập ID danh mục cần cập nhật: ");
                    String updateId = sc.nextLine();
                    for (Category category : categoryList) {
                        if (category.getCategoryId().equals(updateId)) {
                            System.out.println("Nhập tên mới: ");
                            category.setCategoryName(sc.nextLine());
                            System.out.println("Nhập mô tả mới: ");
                            category.setDescription(sc.nextLine());
                            found = true;
                            System.out.println("Danh mục đã được cập nhật.");
                            break;
                        }
                        if (!found) {
                            System.out.println("Danh mục không tồn tại!");
                        }
                    }
                    break;

                //Chức năng 4: Xóa danh mục
                case 4:
                    System.out.println("Nhập ID danh mục cần xóa: ");
                    String deleteId = sc.nextLine();
                    found = false;
                    for (int i = 0; i < categoryList.size(); i++) {
                        if (categoryList.get(i).getCategoryId().equals(deleteId)) {
                            categoryList.remove(i);
                            found = true;
                            System.out.println("Danh mục đã được xóa.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Danh mục không tồn tại.");
                    }
                    break;

                //Chức năng 5: Tìm kiếm danh mục theo tên
                case 5:
                    System.out.println("Nhập tên danh mục cần tìm: ");
                    String searchName = sc.nextLine();
                    System.out.println("Danh sách danh mục khớp tên: ");
                    found = false;
                    for (Category category : categoryList) {
                        if (category.getCategoryName().toLowerCase().contains(searchName.toLowerCase())) {
                            System.out.println("ID: " + category.getCategoryId() + ", Tên: " + category.getCategoryName() + ", Mô tả: " + category.getDescription());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy danh mục khớp với tên.");
                    }
                    break;

                //Chức năng 6: Thoát
                case 6:
                    System.out.println("Thoát khỏi chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");

            }
        } while (choice != 6);

        //Đóng scanner
        sc.close();
    }

    //Lớp Category
    public static class Category{
        //Thuộc tính
        private String categoryId;
        private String categoryName;
        private String description;

        //Constructor

        public Category(String categoryId, String categoryName, String description) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.description = description;
        }


        //Phương thức getter và setter
        public String getCategoryId() {
            return categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public String getDescription() {
            return description;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
