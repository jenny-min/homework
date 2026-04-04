package session13.Exercise06.business.model;

public class Task {
    private Integer id;
    private String taskName;
    private String status;

    public Task() {
    }

    public Task(Integer id, String taskName, String status) {
        this.id = id;
        this.taskName = taskName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Công việc{" +
                "ID: " + id +
                ", Công việc: '" + taskName + '\'' +
                ", Trạng thái: '" + status + '\'' +
                '}';
    }
}
