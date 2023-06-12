import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class GUIm extends JFrame {
    private JPanel daysPanel;
    private List<List<String>> reminders;

    public GUIm() {
        super("Calendar Month view");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel daysOfWeekPanel = new JPanel(new GridLayout(1, 7));

        daysPanel = new JPanel(new GridLayout(0, 7));
        reminders = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            reminders.add(new ArrayList<>());
        }

        Border border = BorderFactory.createLineBorder(Color.GRAY);
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.getDefault());
        String[] dayNames = dateFormatSymbols.getShortWeekdays();

        JLabel monthYearLabel = new JLabel();
        monthYearLabel.setBorder(border);
        monthYearLabel.setPreferredSize(new Dimension(500, 20));
        labelPanel.add(monthYearLabel);

        JLabel dateTimeLabel = new JLabel();
        dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        labelPanel.add(dateTimeLabel);

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        monthYearLabel.setText(getMonthName(month) + " " + year);

        for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
            JLabel dayLabel = new JLabel(dayNames[i].substring(0, 2), SwingConstants.CENTER);
            dayLabel.setBorder(border);
            daysOfWeekPanel.add(dayLabel);

            // Adjust the font size for specific days
            if (i == Calendar.MONDAY || i == Calendar.TUESDAY || i == Calendar.WEDNESDAY ||
                    i == Calendar.THURSDAY || i == Calendar.FRIDAY || i == Calendar.SATURDAY || i == Calendar.SUNDAY) {
                dayLabel.setFont(dayLabel.getFont().deriveFont(Font.PLAIN, 12));
            }
        }

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = Calendar.SUNDAY; i < startDayOfWeek; i++) {
            JLabel emptyLabel = new JLabel("", SwingConstants.CENTER);
            emptyLabel.setBorder(border);
            daysPanel.add(emptyLabel);
        }

        int maxDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int day = 1; day <= maxDaysInMonth; day++) {
            final int currentDay = day;
            JLabel dayLabel = new JLabel(String.valueOf(day), SwingConstants.CENTER);
            dayLabel.setBorder(border);
            dayLabel.setPreferredSize(new Dimension(30, 30));
            dayLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    showRemindersForDay(currentDay);
                }
            });
            daysPanel.add(dayLabel);
        }

        Timer timer = new Timer(1000, e -> {
            Calendar currentDateTime = Calendar.getInstance();
            int hour = currentDateTime.get(Calendar.HOUR);
            if (hour == 0) {
                hour = 12; // Set hour to 12 if it's 0 (midnight)
            }
            String dateTimeText = String.format(
                    "%02d:%02d:%02d %s, %s %d, %d",
                    hour,
                    currentDateTime.get(Calendar.MINUTE),
                    currentDateTime.get(Calendar.SECOND),
                    currentDateTime.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault()),
                    getMonthName(currentDateTime.get(Calendar.MONTH)),
                    currentDateTime.get(Calendar.DAY_OF_MONTH),
                    currentDateTime.get(Calendar.YEAR)
            );
            dateTimeLabel.setText(dateTimeText);
        });
        timer.setInitialDelay(0);
        timer.start();

        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(daysOfWeekPanel, BorderLayout.CENTER);
        mainPanel.add(daysPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void addReminder(String taskName, LocalDateTime dueDate) {
        int dayOfMonth = dueDate.getDayOfMonth();
        if (dayOfMonth >= 1 && dayOfMonth <= 31) {
            reminders.get(dayOfMonth - 1).add(taskName);
        }
    }

    private String getMonthName(int month) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.getDefault());
        return dateFormatSymbols.getMonths()[month];
    }

    private void showRemindersForDay(int day) {
        List<String> remindersForDay = reminders.get(day - 1);
        StringBuilder message = new StringBuilder();
        if (remindersForDay.isEmpty()) {
            message.append("No reminders for day ").append(day);
        } else {
            message.append("Reminders for day ").append(day).append(":\n");
            for (String reminder : remindersForDay) {
                message.append("- ").append(reminder).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, message.toString(), "Reminders", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        GUIm gui = new GUIm();
        gui.addReminder("Task 1", LocalDateTime.now().plusDays(2));
    }
}
