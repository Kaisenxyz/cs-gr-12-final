import java.util.Scanner;

public class tasks {
    public String taskName;
    public int dueDate;

    public tasks(String taskName, int dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public static Task createTask(String taskName, int dueDate) {
        return new Task(taskName, dueDate);
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Task Manager!");

        while (true) {
            System.out.print("Enter task name (or 'quit' to exit): ");
            String taskName = scanner.nextLine();

            if (taskName.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.print("Enter due date (as an integer): ");
            int dueDate = Integer.parseInt(scanner.nextLine());

            Task task = Task.createTask(taskName, dueDate);
            calendar.addTask(task);
        }

        System.out.println("\nUpcoming tasks and deadlines:");
        calendar.displayTasks();
    }
}
