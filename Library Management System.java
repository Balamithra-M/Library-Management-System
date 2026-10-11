```java
import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public void display() {
        System.out.println(
            "Book ID: " + id +
            " | Title: " + title +
            " | Author: " + author +
            " | Status: " + (issued ? "Issued" : "Available")
        );
    }
}

// Member Class
class Member {
    private int id;
    private String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void display() {
        System.out.println(
            "Member ID: " + id + " | Name: " + name
        );
    }
}

// Main Class
public class LibraryManagementSystem {

    private static final ArrayList<Book> books = new ArrayList<>();
    private static final ArrayList<Member> members = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    // Find Book by ID
    private static Book findBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Add Book
    private static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (id <= 0 || findBook(id) != null) {
                System.out.println("Invalid or duplicate Book ID.");
                return;
            }

            System.out.print("Enter Book Title: ");
            String title = scanner.nextLine().trim();

            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine().trim();

            if (title.isEmpty() || author.isEmpty()) {
                System.out.println("Title and author cannot be empty.");
                return;
            }

            books.add(new Book(id, title, author));
            System.out.println("Book added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Search Book
    private static void searchBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Book book = findBook(id);

            if (book != null) {
                book.display();
            } else {
                System.out.println("Book not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
        }
    }

    // Display All Books
    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- BOOK LIST ---");

        for (Book book : books) {
            book.display();
        }
    }

    // Issue Book
    private static void issueBook() {
        try {
            System.out.print("Enter Book ID to issue: ");
            int id = Integer.parseInt(scanner.nextLine());

            Book book = findBook(id);

            if (book == null) {
                System.out.println("Book not found.");
            } else if (book.isIssued()) {
                System.out.println("Book is already issued.");
            } else {
                book.issueBook();
                System.out.println("Book issued successfully!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
        }
    }

    // Return Book
    private static void returnBook() {
        try {
            System.out.print("Enter Book ID to return: ");
            int id = Integer.parseInt(scanner.nextLine());

            Book book = findBook(id);

            if (book == null) {
                System.out.println("Book not found.");
            } else if (!book.isIssued()) {
                System.out.println("This book has not been issued.");
            } else {
                book.returnBook();
                System.out.println("Book returned successfully!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Book ID.");
        }
    }

    // Register Member
    private static void addMember() {
        try {
            System.out.print("Enter Member ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (id <= 0) {
                System.out.println("Member ID must be positive.");
                return;
            }

            for (Member member : members) {
                if (member.getId() == id) {
                    System.out.println("Member ID already exists.");
                    return;
                }
            }

            System.out.print("Enter Member Name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Member name cannot be empty.");
                return;
            }

            members.add(new Member(id, name));
            System.out.println("Member registered successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid Member ID.");
        }
    }

    // Display All Members
    private static void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        System.out.println("\n--- MEMBER LIST ---");

        for (Member member : members) {
            member.display();
        }
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Register Member");
            System.out.println("7. Display All Members");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addBook();
                        break;

                    case 2:
                        searchBook();
                        break;

                    case 3:
                        displayBooks();
                        break;

                    case 4:
                        issueBook();
                        break;

                    case 5:
                        returnBook();
                        break;

                    case 6:
                        addMember();
                        break;

                    case 7:
                        displayMembers();
                        break;

                    case 8:
                        System.out.println("Thank you for using the Library Management System!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Select 1 to 8.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
            }
        }
    }
}
```
