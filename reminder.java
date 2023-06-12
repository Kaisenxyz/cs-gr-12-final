import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Reminder {
    public static void main(String[] args) {
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
}
