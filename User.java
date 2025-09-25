import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private List<Book> issuedBooks;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.issuedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }

    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    @Override
    public String toString() {
        return "User: " + name + " (ID: " + userId + ")";
    }
}
