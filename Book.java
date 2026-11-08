
public class Book {

    private String title;
    private String author;
    private Student borrowedBy;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowedBy = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Student getBorrowedBy() {
        return borrowedBy;
    }

    // Method borrowBy()
    public boolean borrowBy(Student student) {

        if (student == null ||
            borrowedBy != null ||
            student.getBorrowedBook() != null) {
            return false;
        }

        borrowedBy = student;
        student.setBorrowedBook(this);

        return true;
    }

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}
