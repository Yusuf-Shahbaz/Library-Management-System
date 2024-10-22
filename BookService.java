import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
 
public class BookService {
    private List<Book> books = new ArrayList<>();
 
    /**
     * Retrieve all books in the collection.
     * @return List of all books
     */
    public List<Book> getAllBooks() {
        return books;
    }
 
    /**
     * Find a book by its ID.
     * @param id The ID of the book to be retrieved
     * @return The book if found
     * @throws LibraryException If no book with the given ID exists
     */
    public Book getBookById(Long id) throws LibraryException {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new LibraryException("Book not found with id: " + id);
    }
 
    /**
     * Add a new book to the collection.
     * @param book The book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }
 
    /**
     * Update the details of an existing book.
     * @param id The ID of the book to be updated
     * @param updatedBook The book object with updated values
     * @throws LibraryException If no book with the given ID exists
     */
    public void updateBook(Long id, Book updatedBook) throws LibraryException {
        Book book = getBookById(id);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
    }
 
    /**
     * Delete a book from the collection by its ID.
     * @param id The ID of the book to be deleted
     * @throws LibraryException If no book with the given ID exists
     */
    public void deleteBook(Long id) throws LibraryException {
        Book book = getBookById(id);
        books.remove(book);
    }
 
    /**
     * Search for books by title.
     * @param title The title or partial title to search for
     * @return A list of books that match the title
     */
    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
 
    /**
     * Count the total number of books in the collection.
     * @return The number of books
     */
    public int countBooks() {
        return books.size();
    }
 
    /**
     * Find a book by its ISBN number.
     * @param isbn The ISBN of the book
     * @return Optional containing the book if found, empty otherwise
     */
    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }
 
    /**
     * Check if a book exists by its ID.
     * @param id The ID to check
     * @return true if the book exists, false otherwise
     */
    public boolean bookExists(Long id) {
        return books.stream().anyMatch(book -> book.getId().equals(id));
    }
}
