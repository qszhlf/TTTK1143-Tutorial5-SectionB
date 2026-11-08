
import javax.swing.*;
import java.awt.*;

public class BorrowBookGUI extends JFrame {

    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;
    private JTextArea txtBorrowInfo;

    public BorrowBookGUI() {

        setTitle("Borrow Book");
        setSize(550, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Student and Book Selection
        JPanel selectionPanel = new JPanel(
            new GridLayout(3, 2, 10, 5)
        );

        JLabel lblStudent = new JLabel(
            "Student Name & Matric:"
        );

        JLabel lblBook = new JLabel(
            "Book Title & Author:"
        );

        cmbStudent = new JComboBox<>();
        cmbBook = new JComboBox<>();

        // Load student data
        for (Student student : StudentData.students) {
            cmbStudent.addItem(student);
        }

        // Load book data
        for (Book book : BookData.books) {
            cmbBook.addItem(book);
        }

        btnBorrow = new JButton("Borrow");

        selectionPanel.add(lblStudent);
        selectionPanel.add(cmbStudent);

        selectionPanel.add(lblBook);
        selectionPanel.add(cmbBook);

        selectionPanel.add(new JLabel(""));
        selectionPanel.add(btnBorrow);

        pane.add(selectionPanel, BorderLayout.NORTH);

        // Borrow Information
        JPanel infoPanel = new JPanel(new BorderLayout());

        infoPanel.add(
            new JLabel("Borrow Information :"),
            BorderLayout.NORTH
        );

        txtBorrowInfo = new JTextArea();
        txtBorrowInfo.setEditable(false);
        txtBorrowInfo.setLineWrap(true);
        txtBorrowInfo.setWrapStyleWord(true);

        infoPanel.add(
            new JScrollPane(txtBorrowInfo),
            BorderLayout.CENTER
        );

        pane.add(infoPanel, BorderLayout.CENTER);

        // Borrow Button Event
        btnBorrow.addActionListener(e -> {

            Student student =
                (Student) cmbStudent.getSelectedItem();

            Book book =
                (Book) cmbBook.getSelectedItem();

            if (student == null || book == null) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select a student and a book."
                );
                return;
            }

            // Each student can borrow only one book
            if (student.getBorrowedBook() != null) {
                JOptionPane.showMessageDialog(
                    this,
                    "This student already borrowed a book."
                );
                return;
            }

            // Each book has only one copy
            if (book.getBorrowedBy() != null) {
                JOptionPane.showMessageDialog(
                    this,
                    "This book is already borrowed."
                );
                return;
            }

           if (!book.borrowBy(student)) {
    JOptionPane.showMessageDialog(
        this,
        "Borrow failed! Student or book is unavailable."
    );
    return;
}

            txtBorrowInfo.setText(
                student.getName() +
                " with matric number " +
                student.getMatric() +
                " has borrow a book with title " +
                book.getTitle() + "."
            );
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BorrowBookGUI().setVisible(true);
        });
    }
}
