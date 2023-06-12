port java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ReminderGUIIntegration.registerReminder("Task 1", LocalDateTime.now());
        ReminderGUIIntegration.registerReminder("Task 2", LocalDateTime.now().plusHours(1));
        ReminderGUIIntegration.printReminders();
    }
}
