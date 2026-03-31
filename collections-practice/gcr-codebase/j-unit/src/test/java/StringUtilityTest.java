import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilityTest {

    StringUtility utils = new StringUtility();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    @Test
    void testPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("java"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("JAVA", utils.toUpperCase("java"));
    }
}
