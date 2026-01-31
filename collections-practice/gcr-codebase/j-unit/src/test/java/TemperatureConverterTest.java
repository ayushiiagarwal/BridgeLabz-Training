import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(59.0, converter.celsiusToFahrenheit(15));
        assertEquals(239.0, converter.celsiusToFahrenheit(115));
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(15.0, converter.fahrenheitToCelsius(59));
        assertEquals(115.0, converter.fahrenheitToCelsius(239));
    }
}