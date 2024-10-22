import java.time.LocalDateTime;
 
public class LibraryException extends Exception {
    private LocalDateTime timestamp;
    private String errorCode;
 
    /**
     * Constructor for LibraryException with a custom message.
     * @param message The detail message of the exception.
     */
    public LibraryException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now(); // Capture the time when the exception is thrown
    }
 
    /**
     * Constructor for LibraryException with a custom message and an error code.
     * @param message The detail message of the exception.
     * @param errorCode A custom error code associated with the exception.
     */
    public LibraryException(String message, String errorCode) {
        super(message);
        this.timestamp = LocalDateTime.now(); // Capture the time when the exception is thrown
        this.errorCode = errorCode; // Set the custom error code
    }
 
    /**
     * Get the timestamp of when the exception was thrown.
     * @return A LocalDateTime object representing when the exception was thrown.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
 
    /**
     * Get the custom error code associated with this exception.
     * @return The error code as a String.
     */
    public String getErrorCode() {
        return errorCode;
    }
 
    /**
     * Override the default toString method to include custom fields.
     * @return A string representation of the exception including message, timestamp, and error code.
     */
    @Override
    public String toString() {
        return "LibraryException{" +
                "message='" + getMessage() + '\'' +
                ", timestamp=" + timestamp +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
 
    /**
     * Override the default getMessage method to include the error code in the message.
     * @return The exception message including the error code.
     */
    @Override
    public String getMessage() {
        String originalMessage = super.getMessage();
        return errorCode != null ? originalMessage + " (Error Code: " + errorCode + ")" : originalMessage;
    }
}
