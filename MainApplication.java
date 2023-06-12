import java.time.LocalDateTime;

public class MainApplication {
    public static void main(String[] args) {
        GUIm gui = new GUIm();

        // Create a separate thread for running the Reminder input
        Thread reminderThread = new Thread(() -> {
            Reminder reminder = new Reminder();
            reminder.run();
        });
        reminderThread.start();
    }
}
