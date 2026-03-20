package session08.Exercise01;

public class Main {
    public static void main(String[] args) {
        //Mảng chứa danh sách động vật
        Animals[] animalsArray = new Animals[2];

        //Tạo đối tượng
        Dog dog1 = new Dog("Buđy", 3, "Golden Retriever");
        Cat cat1 = new Cat("Wiskers", 2, "Ghi");

        //Thêm vào mảng
        animalsArray[0] = dog1;
        animalsArray[1] = cat1;

        //Hiển thị thông tin và âm thanh
        for (Animals animals : animalsArray) {
            animals.displayInfo();
            System.out.println("Âm thanh: " + animals.makeSound());
            System.out.println();
        }
    }
}
