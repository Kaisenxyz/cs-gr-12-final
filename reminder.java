import java.util.Scanner;

public class Reminder {
    private String taskName;
    private int dueDate;

    public Reminder(String taskName, int dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public static Reminder createReminder(String taskName, int dueDate) {
        return new Reminder(taskName, dueDate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Reminder!");

        while (true) {
            System.out.print("Enter task name (or 'quit' to exit): ");
            String taskName = scanner.nextLine();

            if (taskName.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.print("Enter due date (as an integer): ");
            int dueDate = Integer.parseInt(scanner.nextLine());

            Reminder reminder = Reminder.createReminder(taskName, dueDate);
            reminder.displayReminder();
        }
    }

    public void displayReminder() {
        System.out.println("Reminder: " + taskName);
        System.out.println("Due Date: " + dueDate);
        System.out.println();
    }

}
