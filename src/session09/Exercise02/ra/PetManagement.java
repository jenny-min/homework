package session09.Exercise02.ra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pet> petList = new ArrayList<>();

        while (true) {
            System.out.println("*********************QUẢN LÝ THÚ CƯNG********************");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    if (petList.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        petList.forEach(Pet::displayData);
                    }
                    break;

                case 2:
                    System.out.println("1. Thêm chó");
                    System.out.println("2. Thêm mèo");
                    int type = Integer.parseInt(scanner.nextLine());

                    Pet pet = null;
                    if (type == 1) {
                        pet = new Dog();
                    } else if (type == 2) {
                        pet = new Cat();
                    }

                    if (pet != null) {
                        pet.inputData(scanner);
                        petList.add(pet);
                    }
                    break;

                case 3:
                    for (Pet p : petList) {
                        p.displayData();
                        p.speak();
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    String deleteId = scanner.nextLine();

                    boolean found = false;
                    for (Pet p : petList) {
                        if (p.getPetId().equals(deleteId)) {
                            petList.remove(p);
                            Pet.petIds.remove(deleteId);
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Đã xóa!");
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    String name = scanner.nextLine().toLowerCase();

                    boolean exist = false;
                    for (Pet p : petList) {
                        if (p.getPetName().toLowerCase().contains(name)) {
                            p.displayData();
                            exist = true;
                        }
                    }

                    if (!exist) {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}
