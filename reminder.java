import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Reminder implements Runnable {
    
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Reminder tab!");

        while (true) {
            System.out.print("Enter task name (or 'quit' to exit): ");
            String taskName = scanner.nextLine();

            if (taskName.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.print("Enter due date and time (format: MM/dd/yyyy HH:mm): ");
            String dueDateTimeStr = scanner.nextLine();

            try {
                LocalDateTime dueDateTime = LocalDateTime.parse(dueDateTimeStr, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));
                ReminderGUIIntegration.registerReminder(taskName, dueDateTime);
                System.out.println("Reminder added successfully!");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date and time format. Please try again.");
            }
        }

        System.out.println("Exiting the Reminder tab. Goodbye!");
        scanner.close();
    }

    public static void main(String[] args) {
        Reminder reminder = new Reminder();
        reminder.run();
    }
}
