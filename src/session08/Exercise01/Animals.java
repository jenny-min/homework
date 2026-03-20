package session08.Exercise01;

public class Animals {
   private String name;
   private int age;

   //Constructor
   public Animals(String name, int age) {
      if (name == null) {
         throw new IllegalArgumentException("Tên không được để trống");
      }
      if (age < 0) {
         throw new IllegalArgumentException("Tuổi không được để trống");
      }
      this.name = name;
      this.age = age;
   }

   //Getter và Setter
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   //Phương thức hiển thị thông tin chung
   public void displayInfo() {
      System.out.println("Tên: " + name + ", Tuổi: " + age);
   }

   //Phương thức makeSound()
   public String makeSound() {
      return "Some generic sound";
   }
}
