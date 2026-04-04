package session13.Exercise06.business.dao;

import session13.Exercise06.business.model.Task;

import java.util.List;

public interface ITaskDao {
    List<Task> taskList();
    void addTask(Task task);
    void updateTaskStatus(Task task);
    void deleteTask(int taskId);
    void searchTaskByName(String taskName);
    void taskStatistics();
}
