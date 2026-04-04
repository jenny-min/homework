package session14.Exercise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String url = "session14:mysql://localhost:3306/session14?createDatabaseIfNotExist=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "Nguyenthuy92@";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
