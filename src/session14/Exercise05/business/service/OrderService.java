package session14.Exercise05.business.service;

import com.mysql.cj.jdbc.CallableStatement;
import utils.ConnectionDB;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderService {
    public void placeOrder(int customerId, BigDecimal totalAmount, int productId, int quantity) {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConnectionDB.openConnection();
            if (connection != null) {
                connection.setAutoCommit(false);

                // Đảm bảo đủ 5 dấu hỏi
                callableStatement = (CallableStatement) connection.prepareCall("{call place_order(?, ?, ?, ?, ?)}");

                callableStatement.setInt(1, customerId);
                callableStatement.setBigDecimal(2, totalAmount);
                callableStatement.setInt(3, productId);
                callableStatement.setInt(4, quantity);

                // Đăng ký tham số OUT
                callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);

                // === BỔ SUNG LỆNH NÀY (CỰC KỲ QUAN TRỌNG) ===
                callableStatement.execute();

                // Sau khi execute mới được lấy kết quả
                String result = callableStatement.getString(5);
                System.out.println("Thông báo từ hệ thống: " + result);

                connection.commit();
            }
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback nếu có lỗi
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw new RuntimeException(e);
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close(); // Đóng CallableStatement
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close(); // Đóng kết nối
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
