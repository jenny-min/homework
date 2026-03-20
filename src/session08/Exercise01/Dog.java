package session08.Exercise01;

public class Dog extends Animals{
    private String breed;

    //constructor
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    //getter và setter
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    //Ghi đè phương thức displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();//Gọi phương thức displayInfo của lớp cha Animals
        System.out.println("Giống chó: " + breed);
    }

    //Ghi đè phương thức makeSound
    @Override
    public String makeSound() {
        return "Woof Woof";
    }
}
