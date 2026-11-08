
import javax.swing.*;
import java.awt.*;

public class AddBookGUI extends JFrame {

    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtBooks;

    public AddBookGUI() {

        setTitle("Add Book Info");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 5));

        JLabel lblTitle = new JLabel("Book Title:");
        JLabel lblAuthor = new JLabel("Author:");

        txtTitle = new JTextField();
        txtAuthor = new JTextField();

        inputPanel.add(lblTitle);
        inputPanel.add(txtTitle);
        inputPanel.add(lblAuthor);
        inputPanel.add(txtAuthor);

        // Button Panel
        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Add");
        btnList = new JButton("List");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnList);

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        pane.add(topPanel, BorderLayout.NORTH);

        // Books List
        JPanel listPanel = new JPanel(new BorderLayout(5, 5));
        listPanel.add(new JLabel("Books:"), BorderLayout.NORTH);

        txtBooks = new JTextArea();
        txtBooks.setEditable(false);

        listPanel.add(new JScrollPane(txtBooks), BorderLayout.CENTER);

        pane.add(listPanel, BorderLayout.CENTER);

        // Add Button Event
        btnAdd.addActionListener(e -> {

            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();

            if (title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter book title and author."
                );
                return;
            }

            Book book = new Book(title, author);
            BookData.books.add(book);

            JOptionPane.showMessageDialog(
                this,
                "Book added successfully!"
            );

            txtTitle.setText("");
            txtAuthor.setText("");
        });

        // List Button Event
        btnList.addActionListener(e -> {

            txtBooks.setText("");

            for (Book book : BookData.books) {
                txtBooks.append(book.toString() + "\n");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddBookGUI().setVisible(true);
        });
    }
}
