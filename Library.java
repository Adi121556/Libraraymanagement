import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public User findUserById(String userId) {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return u;
            }
        }
        return null;
    }

    public boolean issueBook(String isbn, String userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);

        if (book == null || user == null || book.isIssued()) {
            return false;
        }

        book.issue();
        user.issueBook(book);
        return true;
    }

    public boolean returnBook(String isbn, String userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);

        if (book == null || user == null || !book.isIssued()) {
            return false;
        }

        book.returnBook();
        user.returnBook(book);
        return true;
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUserDetails(String userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println(user);
            System.out.println("Issued Books:");
            for (Book b : user.getIssuedBooks()) {
                System.out.println(" - " + b.getTitle());
            }
        } else {
            System.out.println("User not found.");
        }
    }
}
