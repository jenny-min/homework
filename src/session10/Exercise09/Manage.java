package session10.Exercise09;

public interface Manage<T> {
    void add(T t);
    void remove(String phoneNumber);
    boolean search(String phoneNumber);
    void display();
}
