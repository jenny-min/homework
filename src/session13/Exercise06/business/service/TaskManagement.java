package session13.Exercise06.business.service;

import session13.Exercise06.business.dao.ITaskDao;
import session13.Exercise06.business.model.Task;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskManagement implements ITaskDao {
    @Override
    public List<Task> taskList() {
        //Tạo list đối tượng trả về
        List<Task> tasks = new ArrayList<>();
        //B1:Mở kết nôi
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng callable
        try {
            CallableStatement call = conn.prepareCall("{call list_tasks()}");

            //Thực thi truy vấn
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Task t = new Task(
                        rs.getInt("id"),
                        rs.getNString("task_name"),
                        rs.getString("status")
                );
                //thêm vào list nếu phát hiện có tồn tại đối tượng
                tasks.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        //B1:Mở kết nôi
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng callable
        try {
            CallableStatement call = conn.prepareCall("{call add_task(?,?)}");
            //Truyền đối  sô
            call.setString(1, task.getTaskName());
            call.setString(2, task.getStatus());
            //Thực thi truy vấn
            call.executeUpdate();
            System.out.println("Thêm thành công!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateTaskStatus(Task task) {
        //B1:Mở kết nôi
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng callable
        try {
            CallableStatement call = conn.prepareCall("{call update_task_status(?,?)}");
            //Truyền đối  sô
            call.setInt(1, task.getId());
            call.setString(2, task.getStatus());
            //Thực thi truy vấn
            call.executeUpdate();
            System.out.println("Cập nhật trạng thái thành công!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteTask(int taskId) {
        //B1: Mở kết nối
        Connection conn = ConnectionDB.openConnection();
        //B2: Tạo truy vấn bằng Callable
        try {
            CallableStatement call = conn.prepareCall("{call delete_task(?)}");

            call.setInt(1, taskId);

            //B3: Thực thi truy vấn
            call.executeUpdate();
            System.out.println("Xóa công việc thành công");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void searchTaskByName(String taskName) {
        Connection conn = ConnectionDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call search_task_by_name(?)}");
            call.setString(1, taskName);
            ResultSet rs = call.executeQuery();
            System.out.println("--- Kết quả tìm kiếm ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Task: %s | Status: %s\n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void taskStatistics() {
        Connection conn = ConnectionDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call task_statistics()}");
            ResultSet rs = call.executeQuery();
            System.out.println("--- Thống kê công việc ---");
            while (rs.next()) {
                System.out.printf("Trạng thái: %s | Số lượng: %d\n",
                        rs.getString("status"), rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
