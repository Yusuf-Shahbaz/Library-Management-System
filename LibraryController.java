import java.util.InputMismatchException;
import java.util.Scanner;
 
public class LibraryController {
    private BookService bookService = new BookService();
    private UserService userService = new UserService();
 
    /**
     * Display the main menu and handle user input.
     */
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add User");
            System.out.println("6. View Users");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline
 
                switch (option) {
                    case 1:
                        addBook(scanner);
                        break;
                    case 2:
                        viewBooks();
                        break;
                    case 3:
                        updateBook(scanner);
                        break;
                    case 4:
                        deleteBook(scanner);
                        break;
                    case 5:
                        addUser(scanner);
                        break;
                    case 6:
                        viewUsers();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
 
    /**
     * Add a new book to the library.
     * @param scanner A Scanner object to get user input.
     */
    private void addBook(Scanner scanner) {
        try {
            System.out.print("Enter book ID: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            System.out.print("Enter book ISBN: ");
            String isbn = scanner.nextLine();
 
            Book book = new Book(id, title, author, isbn);
            bookService.addBook(book);
            System.out.println("Book added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear invalid input
        }
    }
 
    /**
     * Display all books in the library.
     */
    private void viewBooks() {
        System.out.println("\nBooks in the library:");
        if (bookService.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : bookService.getAllBooks()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn());
            }
        }
    }
 
    /**
     * Update details of an existing book.
     * @param scanner A Scanner object to get user input.
     */
    private void updateBook(Scanner scanner) {
        try {
            System.out.print("Enter book ID to update: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new author: ");
            String author = scanner.nextLine();
            System.out.print("Enter new ISBN: ");
            String isbn = scanner.nextLine();
 
            Book updatedBook = new Book(id, title, author, isbn);
            bookService.updateBook(id, updatedBook);
            System.out.println("Book updated successfully!");
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear invalid input
        }
    }
 
    /**
     * Delete a book from the library.
     * @param scanner A Scanner object to get user input.
     */
    private void deleteBook(Scanner scanner) {
        try {
            System.out.print("Enter book ID to delete: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            bookService.deleteBook(id);
            System.out.println("Book deleted successfully!");
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid book ID.");
            scanner.nextLine(); // Clear invalid input
        }
    }
 
    /**
     * Add a new user to the library system.
     * @param scanner A Scanner object to get user input.
     */
    private void addUser(Scanner scanner) {
        try {
            System.out.print("Enter user ID: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter user name: ");
            String name = scanner.nextLine();
            System.out.print("Enter user email: ");
            String email = scanner.nextLine();
 
            User user = new User(id, name, email);
            userService.addUser(user);
            System.out.println("User added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); // Clear invalid input
        }
    }
 
    /**
     * Display all users in the library system.
     */
    private void viewUsers() {
        System.out.println("\nUsers in the library:");
        if (userService.getAllUsers().isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : userService.getAllUsers()) {
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName() +
                        ", Email: " + user.getEmail());
            }
        }
    }
}
