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
    }

    public static void registerReminder(String taskName, LocalDateTime dueDate) {
        SwingUtilities.invokeLater(() -> {
            gui.addReminder(taskName, dueDate);
        });
    }
}
