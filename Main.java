import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Add some initial books
        library.addBook(new Book("Koi to baat hai", "Aditya", "B001"));
        library.addBook(new Book("chal sath chale", "harichand", "B002"));
        library.addBook(new Book("koi hai", "k.abdul khan", "B003"));
         library.addBook(new Book("Sona mat", "l.parul chanda", "B004"));
        library.addBook(new Book("Tumne kuch dekha", "aman aggrawal", "B005"));
        library.addBook(new Book("Ajkal bade badle ho", "L.fatehi", "B006"));

        // Add some users
         library.addUser(new User("Aman", "U001"));
        library.addUser(new User("Akbar", "U002"));
        library.addUser(new User("Pawan", "U003"));
        library.addUser(new User("Khushi", "U004"));
        

        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show All Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show User Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ISBN: ");
                    String isbnIssue = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String userIdIssue = sc.nextLine();
                    if (library.issueBook(isbnIssue, userIdIssue)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Issue failed. Book might be already issued or not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Book ISBN: ");
                    String isbnReturn = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String userIdReturn = sc.nextLine();
                    if (library.returnBook(isbnReturn, userIdReturn)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Return failed. Check book/user or if it was issued.");
                    }
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    String uid = sc.nextLine();
                    library.showUserDetails(uid);
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);

        sc.close();
    }
}
