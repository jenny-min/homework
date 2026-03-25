package session09.Exercise02.ra;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public abstract class Pet {
    private String petId;
    private String petName;
    private int age;

    // Dùng để check trùng ID
    public static Set<String> petIds = new HashSet<>();

    public Pet() {
    }

    public Pet(String petId, String petName, int age) {
        this.petId = petId;
        this.petName = petName;
        this.age = age;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Nhập dữ liệu
    public void inputData(Scanner scanner) {
        // ID
        while (true) {
            System.out.print("Nhập mã thú cưng (C/D + 3 số): ");
            String id = scanner.nextLine();
            if (id.matches("^[CD]\\d{3}$") && !petIds.contains(id)) {
                this.petId = id;
                petIds.add(id);
                break;
            } else {
                System.out.println("Sai định dạng hoặc bị trùng!");
            }
        }

        // Name
        while (true) {
            System.out.print("Nhập tên thú cưng (20-50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 20 && name.length() <= 50) {
                this.petName = name;
                break;
            } else {
                System.out.println("Tên phải từ 20-50 ký tự!");
            }
        }

        // Age
        while (true) {
            System.out.print("Nhập tuổi (>0): ");
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age > 0) {
                    this.age = age;
                    break;
                }
            } catch (Exception e) {
            }
            System.out.println("Tuổi không hợp lệ!");
        }
    }

    // Hiển thị
    public void displayData() {
        System.out.printf("ID: %s | Tên: %s | Tuổi: %d\n", petId, petName, age);
    }

    // Abstract
    public abstract void speak();
}
