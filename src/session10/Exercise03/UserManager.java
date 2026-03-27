package session10.Exercise03;

import java.util.LinkedList;

public class UserManager {
    private LinkedList<User> users;

    public UserManager() {users = new LinkedList<>();}

    //Thêm người dùng
    public void addUser(User user) {
        users.add(user);
    }

    //Xóa người dùng
    public boolean removeUser(String email) {
        return users.removeIf(user ->user.getEmail().equals(email));
    }

    //Hiển thị người dùng
    public void displayUser() {
        if (users.isEmpty()) {
            System.out.println("Danh sách người dùng trống!");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
