import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("01-01-2024", formatter.formatDate("2024-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("01-01-2024");
        });
    }

    @Test
    void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2023-02-29");
        });
    }
}