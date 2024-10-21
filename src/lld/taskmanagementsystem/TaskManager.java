package lld.taskmanagementsystem;

/*
Static:
Purpose: Used to create class-level members.
Effect:
Variables: When applied to a variable, it makes it a class variable, meaning it is shared by all instances of the class.
Methods: When applied to a method, it makes it a class method, meaning it can be called directly on the class without creating an instance.
 */
public class TaskManager {
    private static TaskManager instance;
    private final Map<String, Task> tasks;
    private final Map<String, List<Task>> userTasks;

    private TaskManager() {
        tasks = new ConcurrentHashMap<>();
        userTasks = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getInstance() {
        if(instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
        assignTaskToUser(task.getAssignedUser(), task);
    }

    public void updateTask(Task updatedTask) {
        Task currentTask = tasks.get(task.getId());
        if(currentTask != null) {
            synchronized (currentTask) {
                currentTask.setTitle(updatedTask.getTitle());
                currentTask.setDescription(updatedTask.getDescription());
                currentTask.setDueDate(updatedTask.getDueDate());
                currentTask.setPriority(updatedTask.getPriority());
                currentTask.setStatus(updatedTask.getStatus());
                User previousUser = currentTask.getAssignedUser();
                User newUser = updatedTask.getAssignedUser();
                if(!previousUser.equals(newUser)) {
                    unassignTaskFromUser(previousUser, ex);
                }
            }
        }
    }

    public void markTaskAsCompleted(String taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            synchronized (task) {
                task.setStatus(TaskStatus.COMPLETED);
            }
        }
    }

    private void assignTaskToUser(User user, Task task) {
        userTasks.computeIfAbsent(user.getId(), k -> new CopyOnWriteArrayList<>().add(task));
    }

    private void unassignTaskFromUser(User user, Task task) {
        List<Task> tasks = userTasks.get(user.getId());
        if(tasks != null) {
            tasks.remove(task);
        }
        userTasks.put(user.getId(), tasks);
    }
}