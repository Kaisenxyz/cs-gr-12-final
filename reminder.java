import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reminder {
    private String taskName;
    private LocalDateTime dueDate;

    public Reminder(String taskName, LocalDateTime dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public static Reminder createReminder(String taskName, LocalDateTime dueDate) {
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

            System.out.print("Enter due date (format: YYYY/MM/DD): ");
            String dueDateInput = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime dueDate = LocalDateTime.parse(dueDateInput, formatter);

            Reminder reminder = Reminder.createReminder(taskName, dueDate);
            displayReminderAndDateTime(reminder);
        }
    }

    public static void displayReminderAndDateTime(Reminder reminder) {
        System.out.println("Reminder: " + reminder.taskName);
        System.out.println("Due Date: " + reminder.dueDate);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the hour to display in 12-hour format with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String timeFormatted = currentDateTime.format(formatter);

        // Display the current date and time
        System.out.println("Date: " + currentDateTime.toLocalDate());
        System.out.println("Time: " + timeFormatted);

        try {
            // Delay for one second
            Thread.sleep(1000);

            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
