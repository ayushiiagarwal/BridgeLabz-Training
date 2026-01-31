import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
    UserRegistration registration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertTrue(registration.registerUser("olive123", "olive@gmail.com", "OliveSmith1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "olive@gmail.com", "OliveSmith1");
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("olive123", "olivegmail.com", "OliveSmith1");
        });
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("olive123", "olive@gmail.com", "olive");
        });
    }
}