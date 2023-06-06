import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reminder {
    private String taskName;
    private LocalDateTime dueDate;
    private static ReminderGUIIntegration reminderGUIIntegration;

    public Reminder(String taskName, LocalDateTime dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public static void setReminderGUIIntegration(ReminderGUIIntegration integration) {
        reminderGUIIntegration = integration;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Reminder tab!");

        while (true) {
            System.out.print("Enter task name (or 'quit' to exit): ");
            String taskName = scanner.nextLine();

            if (taskName.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.print("Enter due date (format: MM/dd/yyyy): ");
            String dueDateInput = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("/MM/dd/yyyy");
            LocalDateTime dueDate = LocalDateTime.parse(dueDateInput, formatter);

            Reminder reminder = new Reminder(taskName, dueDate);
            ReminderGUIIntegration.registerReminder(reminder.getTaskName(), reminder.getDueDate());
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
