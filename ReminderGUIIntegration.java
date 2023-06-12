import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ReminderGUIIntegration {
    public static void main() {
        
    }
    private static Map<String, LocalDateTime> reminders = new HashMap<>();

    public static void registerReminder(String taskName, LocalDateTime dueDate) {
        reminders.put(taskName, dueDate);
    }

    public static void printReminders() {
        System.out.println("Registered Reminders:");
        if (reminders.isEmpty()) {
            System.out.println("No reminders found.");
        } else {
            for (Map.Entry<String, LocalDateTime> entry : reminders.entrySet()) {
                String taskName = entry.getKey();
                LocalDateTime dueDate = entry.getValue();
                System.out.println("Task: " + taskName + ", Due Date: " + dueDate);
            }
        }
    }

}
