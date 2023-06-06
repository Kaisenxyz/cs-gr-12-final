import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) {
        ReminderGUIIntegration reminderGUIIntegration = new ReminderGUIIntegration();
        Reminder.setReminderGUIIntegration(reminderGUIIntegration);
        reminderGUIIntegration.main(args);
    }
}
