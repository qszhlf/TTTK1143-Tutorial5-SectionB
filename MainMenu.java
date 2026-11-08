
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    private JButton btnStudent, btnBook, btnBorrow;

    public MainMenu() {

        setTitle("Borrow Book System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel(
            "BORROW BOOK SYSTEM", JLabel.CENTER
        );

        btnStudent = new JButton("Add Student Info");
        btnBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");

        pane.add(title);
        pane.add(btnStudent);
        pane.add(btnBook);
        pane.add(btnBorrow);

        btnStudent.addActionListener(e -> {
    new AddStudentGUI().setVisible(true);
});

btnBook.addActionListener(e -> {
    new AddBookGUI().setVisible(true);
});

btnBorrow.addActionListener(e -> {
    new BorrowBookGUI().setVisible(true);
});

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu());
    }
}
