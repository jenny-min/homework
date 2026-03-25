package session09.Exercise02.ra;

public class Cat extends Pet {

    public Cat() {
    }

    public Cat(String petId, String petName, int age) {
        super(petId, petName, age);
    }

    @Override
    public void speak() {
        System.out.println("Meo meo");
    }
}
