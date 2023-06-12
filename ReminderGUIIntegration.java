import javax.swing.SwingUtilities;
import java.time.LocalDateTime;

public class ReminderGUIIntegration {
    private static GUIm gui;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReminderGUIIntegration::createAndShowGUI);
        Reminder.main(args);
    }

    private static void createAndShowGUI() {
        gui = new GUIm();

        // Example usage of the addReminder method
        LocalDateTime dueDate = LocalDateTime.now().plusDays(2);
        gui.addReminder("Task 1", dueDate);
    }

    public static void registerReminder(String taskName, LocalDateTime dueDate) {
        SwingUtilities.invokeLater(() -> {
            gui.addReminder(taskName, dueDate);
        });
    }
}
