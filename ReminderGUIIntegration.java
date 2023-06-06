import javax.swing.SwingUtilities;
import java.time.LocalDateTime;

public class ReminderGUIIntegration {
    private static GUIm gui;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(ReminderGUIIntegration::createAndShowGUI);
        Reminder.main(args);
    }

    private static void createAndShowGUI() {
        gui = new GUIm();
        gui.createAndShowGUI();
    }

    public static void registerReminder(String taskName, LocalDateTime dueDate) {
        SwingUtilities.invokeLater(() -> {
            gui.addReminder(taskName, dueDate);
        });
    }
}
