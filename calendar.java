import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class calendar {
    public static void main(String[] args) {
        while (true) {
            // Get the current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Retrieve individual components of the date and time
            int year = currentDateTime.getYear();
            int month = currentDateTime.getMonthValue();
            int day = currentDateTime.getDayOfMonth();

            // Format the minute to display in 00 style


            // Format the hour to display in 12-hour format with AM/PM
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
            String timeFormatted = currentDateTime.format(formatter);

            // Display the current date and time
            System.out.println("Date: " + month + "/" + day + "/" + year);
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
}
