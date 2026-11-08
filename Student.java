
public class Student {

    private String name;
    private String matric;
    private Book borrowedBook;

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
        this.borrowedBook = null;
    }

    public String getName() {
        return name;
    }

    public String getMatric() {
        return matric;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book book) {
        this.borrowedBook = book;
    }

    @Override
    public String toString() {
        return name + " (" + matric + ")";
    }
}
