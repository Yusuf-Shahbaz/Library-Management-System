import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
 
    // ISBN validation regex pattern (based on common ISBN formats)
    private static final String ISBN_PATTERN = "^(97(8|9))?\\d{9}(\\d|X)$";
 
    // Constructor
    public Book(Long id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        setIsbn(isbn); // Using the setter to validate ISBN
    }
 
    // Getters and setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public String getIsbn() {
        return isbn;
    }
 
    /**
     * Set the ISBN of the book and validate it.
     * @param isbn The ISBN number of the book
     * @throws IllegalArgumentException If the ISBN is invalid
     */
    public void setIsbn(String isbn) {
        if (!isValidIsbn(isbn)) {
            throw new IllegalArgumentException("Invalid ISBN format: " + isbn);
        }
        this.isbn = isbn;
    }
 
    /**
     * Validate the ISBN format using regex.
     * @param isbn The ISBN number to validate
     * @return true if the ISBN is valid, false otherwise
     */
    public static boolean isValidIsbn(String isbn) {
        Pattern pattern = Pattern.compile(ISBN_PATTERN);
        Matcher matcher = pattern.matcher(isbn);
        return matcher.matches();
    }
 
    /**
     * Check if two books are equal based on their ISBN.
     * @param obj The object to compare with
     * @return true if both books have the same ISBN, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(isbn, book.isbn);
    }
 
    /**
     * Generate a hash code based on the ISBN.
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
 
    /**
     * Get a string representation of the Book object.
     * @return A string in the format "Book{id, title, author, isbn}"
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
 
    /**
     * Validate if the book's title is not null or empty.
     * @return true if the title is valid, false otherwise
     */
    public boolean isValidTitle() {
        return title != null && !title.trim().isEmpty();
    }
 
    /**
     * Validate if the book's author is not null or empty.
     * @return true if the author is valid, false otherwise
     */
    public boolean isValidAuthor() {
        return author != null && !author.trim().isEmpty();
    }
 
    /**
     * Check if the book has a valid ID (greater than 0).
     * @return true if the ID is valid, false otherwise
     */
    public boolean isValidId() {
        return id != null && id > 0;
    }
}
