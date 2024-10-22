import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class User {
    private Long id;
    private String name;
    private String email;
 
    // Email validation regex pattern
    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    // Constructor
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        setEmail(email); // Using the setter to validate email
    }
 
    // Getters and setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    /**
     * Set the user's email and validate it against a regex pattern.
     * @param email The user's email
     * @throws IllegalArgumentException If the email is invalid
     */
    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
        this.email = email;
    }
 
    /**
     * Validate the email format using regex.
     * @param email The email to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
 
    /**
     * Check if two users are equal based on their ID.
     * @param obj The object to compare with
     * @return true if both users have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id, user.id);
    }
 
    /**
     * Generate a hash code based on the user's ID.
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
 
    /**
     * Get a string representation of the User object.
     * @return A string in the format "User{id, name, email}"
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
 
    /**
     * Validate if the user's name meets certain criteria.
     * @return true if the name is valid (not empty), false otherwise
     */
    public boolean isValidName() {
        return name != null && !name.trim().isEmpty();
    }
 
    /**
     * Check if the user has a valid ID (greater than 0).
     * @return true if the ID is valid, false otherwise
     */
    public boolean isValidId() {
        return id != null && id > 0;
    }
}
