import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.function.Predicate;
 
// Service to manage user data operations
public class UserService {
    private List<User> users = new ArrayList<>(); // Store users in a list
 
    // Fetch all users in the list
    public List<User> getAllUsers() {
        return users;
    }
 
    // Fetch user by ID, throwing an exception if not found
    public User getUserById(Long id) throws LibraryException {
        return users.stream() // Using streams for concise code
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new LibraryException("User not found with id: " + id));
    }
 
    // Add a new user to the list
    public void addUser(User user) {
        users.add(user);
    }
 
    // Update a user's details based on the provided ID
    public void updateUser(Long id, User updatedUser) throws LibraryException {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
    }
 
    // Delete a user by ID
    public void deleteUser(Long id) throws LibraryException {
        User user = getUserById(id);
        users.remove(user);
    }
 
    // Count the total number of users in the list
    public long countUsers() {
        return users.size();
    }
 
    // Get all users with a specific name
    public List<User> getUsersByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
 
    // Check if a user with the given ID exists
    public boolean userExists(Long id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }
 
    // Get all users sorted by their name
    public List<User> getUsersSortedByName() {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }
 
    // Get users that match a custom filter
    public List<User> filterUsers(Predicate<User> filter) {
        return users.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
