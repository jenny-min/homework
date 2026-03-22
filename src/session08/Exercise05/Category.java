package session08.Exercise05;
//Lớp này đại diện cho một danh mục trong chương trình
public class Category {
    //Thuộc tính
    private int id;
    private String name;
    private String description;

    //Constructor không tham số
    public Category(){};

    //Constructor có tham số
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString () {
        return "ID: " + id + ", Name: " + name + ", Description: " + description;
    }
}
