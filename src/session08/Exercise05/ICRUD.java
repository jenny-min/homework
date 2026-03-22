package session08.Exercise05;

public interface ICRUD {
    Category[] findAll();
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteById(int id);
}
