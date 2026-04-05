package session14.Exercise06.business.service;

import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeProjectManager {
    public void assignEmployeeToProject(int employeeId, int projectId) {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            connection = ConnectionDB.openConnection();
            if (connection != null) {
                connection.setAutoCommit(false); // Bắt đầu transaction

                callableStatement = connection.prepareCall("{call assign_employee_to_project(?, ?, ?)}");
                callableStatement.setInt(1, employeeId);
                callableStatement.setInt(2, projectId);
                callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);

                callableStatement.executeUpdate();
                String result = callableStatement.getString(3); // Lấy kết quả

                System.out.println(result); // In thông báo

                connection.commit(); // Cam kết transaction
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
