import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    Exception utils = new Exception();

    @Test
    void testExceptionThrown() {
        assertThrows(ArithmeticException.class, () -> utils.divide(10, 0));
    }
}