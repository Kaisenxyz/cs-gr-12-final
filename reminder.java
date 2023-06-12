import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
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

            System.out.print("Enter due date (format: MM/dd/yyyy): ");
            String dueDateStr = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);
                LocalDateTime dueDate = LocalDateTime.parse(dueDateStr, formatter);
                ReminderGUIIntegration.registerReminder(taskName, dueDate);
                System.out.println("Reminder added successfully!");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        System.out.println("Exiting the Reminder tab. Goodbye!");
        scanner.close();
    }
}
