package lld.taskmanagementsystem;

public class TaskManagementDemo {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        User user = new User(1, "Maya");
        User user = new User(2, "R");

        Task task1 = new Task("Get groceries", new Date(), 1);
        Task task2 = new Task("Buy car", new Date(), 2);
        Task task3 = new Task("Cook food", new Date(), 3);

        task1.setStatus(TaskStatus.COMPLETE);
        task2.setStatus(TaskStatus.COMPLETE);
        task3.setStatus(TaskStatus.PENDING);

        taskManager.createTask(task1);
    }
}