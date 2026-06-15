import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JTextField nameField;
    private JTextField marksField;
    private JLabel resultLabel;

    public Main() {
        setTitle("Student Grade System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center screen
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // 🔥 TITLE
        JLabel title = new JLabel("STUDENT GRADE SYSTEM");
        title.setBounds(70, 10, 350, 40);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(30, 30, 30));
        add(title);

        // NAME LABEL
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 25);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 70, 220, 30);
        add(nameField);

        // MARKS LABEL
        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(50, 120, 100, 25);
        marksLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(marksLabel);

        marksField = new JTextField();
        marksField.setBounds(150, 120, 220, 30);
        add(marksField);

        // BUTTON
        JButton btn = new JButton("Calculate Grade");
        btn.setBounds(150, 170, 220, 35);
        btn.setBackground(new Color(0, 123, 255));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        add(btn);

        // RESULT LABEL
        resultLabel = new JLabel("");
        resultLabel.setBounds(150, 230, 250, 25);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(new Color(0, 150, 0));
        add(resultLabel);

        // EVENT HANDLING
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String name = nameField.getText();

                    if (name.isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty");
                    }

                    int marks;
                    try {
                        marks = Integer.parseInt(marksField.getText());
                    } catch (NumberFormatException ex) {
                        throw new NumberFormatException("Marks must be a number");
                    }

                    if (marks < 0 || marks > 100) {
                        throw new IllegalArgumentException("Marks must be 0–100");
                    }

                    String grade = calculateGrade(marks);

                    resultLabel.setText(name + " → Grade: " + grade);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // BUSINESS LOGIC
    public String calculateGrade(int marks) {
        if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}