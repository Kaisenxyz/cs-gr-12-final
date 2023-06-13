import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ReminderGUIIntegration {
    private static Map<String, LocalDateTime> reminders = new HashMap<>();
    private GUIm gui;

    public ReminderGUIIntegration() {
        gui = new GUIm();

        JFrame frame = new JFrame("Reminder Application");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Task Name:");
        JTextField nameField = new JTextField();

        JLabel dueDateLabel = new JLabel("Due Date (MM/dd/yyyy):");
        JTextField dueDateField = new JTextField();

        JLabel dueTimeLabel = new JLabel("Due Time (HH:mm):");
        JTextField dueTimeField = new JTextField();

        JButton addButton = new JButton("Add Reminder");
        addButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                String taskName = nameField.getText();
                LocalDateTime dueDateTime = LocalDateTime.parse(dueDateField.getText() + " " + dueTimeField.getText(), DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));
                
                registerReminder(taskName, dueDateTime);
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

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    public void registerReminder(String taskName, LocalDateTime dueDateTime) {
        reminders.put(taskName, dueDateTime);
        gui.updateReminders(taskName, dueDateTime);
        System.out.println("Reminder registered: " + taskName + " - " + dueDateTime);
    }

    public static void main(String[] args) {
        new ReminderGUIIntegration();
    }
}
