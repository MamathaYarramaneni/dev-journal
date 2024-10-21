package lld.taskmanagementsystem;

public class Task {
    private int id;
    private String title;
    private TaskStatus taskStatus;
    private timestamp duedate;
    private User user;

    Task(String title, timestamp dueDate, User user) {
        this.id = generateId();
        this.title = title;
        this.duedate = dueDate;
        this.user = user;
        this.taskStatus = TaskStatus.PROGRESS;
    }

    private int generateId() {
        return (int)Date.getTimeMillis() % Integer.MAX_VALUE;
    }

    private void setStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    private User getAssignedUser() {
        return this.user;
    }
}