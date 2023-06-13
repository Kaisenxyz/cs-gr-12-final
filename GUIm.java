import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class GUIm extends JFrame {

    private JPanel mainPanel;
    private JPanel daysOfWeekPanel;
    private JPanel daysPanel;

    private List<List<ReminderData>> reminders;

    public GUIm() {
        setTitle("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());

        daysOfWeekPanel = new JPanel(new GridLayout(1, 7));
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String dayOfWeek : daysOfWeek) {
            JLabel label = new JLabel(dayOfWeek, JLabel.CENTER);
            daysOfWeekPanel.add(label);
        }

        daysPanel = new JPanel(new GridLayout(6, 7));
        reminders = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            reminders.add(new ArrayList<>());
            JLabel dayLabel = new JLabel(Integer.toString(i + 1), JLabel.CENTER);
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            dayLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int dayOfMonth = Integer.parseInt(dayLabel.getText());
                    showRemindersForDay(dayOfMonth);
                }
            });
            daysPanel.add(dayLabel);
        }

        Calendar currentDateTime = Calendar.getInstance();

        JPanel labelPanel = new JPanel(new BorderLayout());
        JLabel monthLabel = new JLabel(getMonthName(currentDateTime.get(Calendar.MONTH)), JLabel.CENTER);
        monthLabel.setFont(monthLabel.getFont().deriveFont(Font.BOLD, 20));
        labelPanel.add(monthLabel, BorderLayout.NORTH);

        JLabel dateTimeLabel = new JLabel("", JLabel.CENTER);
        dateTimeLabel.setFont(dateTimeLabel.getFont().deriveFont(Font.BOLD, 16));
        labelPanel.add(dateTimeLabel, BorderLayout.CENTER);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hour = currentDateTime.get(Calendar.HOUR_OF_DAY);
                if (hour > 12) {
                    hour -= 12; // Convert from 24-hour format to 12-hour format
                } else if (hour == 0) {
                    hour = 12; // Convert 0 o'clock to 12 for 12-hour format
                }
                int minute = currentDateTime.get(Calendar.MINUTE);
                int second = currentDateTime.get(Calendar.SECOND);
                String dateTime = String.format("%02d:%02d:%02d", hour, minute, second);
                dateTimeLabel.setText(dateTime);
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(daysOfWeekPanel, BorderLayout.CENTER);
        mainPanel.add(daysPanel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add Reminder");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddReminderGUI();
            }
        });
        buttonPanel.add(addButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String getMonthName(int month) {
        String[] monthNames = new DateFormatSymbols(Locale.getDefault()).getMonths();
        return monthNames[month];
    }

    private void showRemindersForDay(int dayOfMonth) {
        List<ReminderData> dayReminders = reminders.get(dayOfMonth - 1);
        StringBuilder reminderText = new StringBuilder();
        if (!dayReminders.isEmpty()) {
            reminderText.append("Reminders for ")
                    .append(getMonthName(Calendar.getInstance().get(Calendar.MONTH)))
                    .append(" ")
                    .append(dayOfMonth)
                    .append(":\n");
            for (ReminderData reminder : dayReminders) {
                reminderText.append("- ")
                        .append(reminder.getTaskName())
                        .append(" (")
                        .append(reminder.getDueDateTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)))
                        .append(")\n");
            }
        } else {
            reminderText.append("No reminders for ")
                    .append(getMonthName(Calendar.getInstance().get(Calendar.MONTH)))
                    .append(" ")
                    .append(dayOfMonth);
        }
        JOptionPane.showMessageDialog(this, reminderText.toString(), "Reminders", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAddReminderGUI() {
        JFrame frame = new JFrame("Add Reminder");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Task Name:");
        JTextField nameField = new JTextField();

        JLabel dueDateLabel = new JLabel("Due Date (MM/dd/yyyy):");
        JTextField dueDateField = new JTextField();

        JLabel dueTimeLabel = new JLabel("Due Time (HH:mm):");
        JTextField dueTimeField = new JTextField();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = nameField.getText();
                LocalDateTime dueDateTime = LocalDateTime.parse(dueDateField.getText() + " " + dueTimeField.getText(), DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));

                ReminderData newReminder = new ReminderData(taskName, dueDateTime);
                int dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                reminders.get(dayOfMonth - 1).add(newReminder);

                frame.dispose();
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(dueDateLabel);
        panel.add(dueDateField);
        panel.add(dueTimeLabel);
        panel.add(dueTimeField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIm();
            }
        });
    }
}
