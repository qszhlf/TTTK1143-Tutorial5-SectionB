
import javax.swing.*;
import java.awt.*;

public class AddStudentGUI extends JFrame {

    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtStudents;

    public AddStudentGUI() {

        setTitle("Add Student Info");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 5));

        JLabel lblName = new JLabel("Name:");
        JLabel lblMatric = new JLabel("Matric:");

        txtName = new JTextField();
        txtMatric = new JTextField();

        inputPanel.add(lblName);
        inputPanel.add(txtName);
        inputPanel.add(lblMatric);
        inputPanel.add(txtMatric);

        // Buttons
        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Add");
        btnList = new JButton("List");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnList);

        // Top section
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        pane.add(topPanel, BorderLayout.NORTH);

        // Student list
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));
        listPanel.add(new JLabel("Students:"), BorderLayout.NORTH);

        txtStudents = new JTextArea();
        txtStudents.setEditable(false);

        listPanel.add(
            new JScrollPane(txtStudents),
            BorderLayout.CENTER
        );

        pane.add(listPanel, BorderLayout.CENTER);

        // Add button event
        btnAdd.addActionListener(e -> {

            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();

            if (name.isEmpty() || matric.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter name and matric number."
                );
                return;
            }

            Student student = new Student(name, matric);
            StudentData.students.add(student);

            JOptionPane.showMessageDialog(
                this,
                "Student added successfully!"
            );

            txtName.setText("");
            txtMatric.setText("");
        });

        // List button event
        btnList.addActionListener(e -> {

            txtStudents.setText("");

            for (Student student : StudentData.students) {
                txtStudents.append(student.toString() + "\n");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddStudentGUI().setVisible(true);
        });
    }
}
