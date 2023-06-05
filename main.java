public class main {
    public static void main(String[] args) {
        Thread calendarThread = new Thread(() -> {
            calendar.displayDateTime();
        });

        Reminder.main(args);

        calendarThread.start();
    }
}
