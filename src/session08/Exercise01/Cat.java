package session08.Exercise01;

public class Cat extends Animals {
    private String furColor;

    //constructor
    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    //getter và setter
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    //Ghi đè phương thức displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();//Gọi phương thức displayInfo của lớp cha Animals
        System.out.println("Màu lông: " + furColor);
    }

    //Ghi đè phương thức makeSound
    public String makeSound() {
        return "Meow Meow";
    }
}
