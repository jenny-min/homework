package session10.Exercise04;

public interface Manage<T> {
    void add(T student);
    void update(int index, T student);
    void delete(int index);
    void display();
}
