import java.util.Scanner;

public class tasks {
    public String taskName;
    public int dueDate;

    public Task(String taskName, int dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
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

            Task task = new Task(taskName, dueDate);
            calendar.addTask(task);
        }

        System.out.println("Upcoming tasks and deadlines:");
        calendar.displayTasks();
    }
}
