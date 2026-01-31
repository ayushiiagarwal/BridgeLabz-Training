import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate); 
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return date.format(formatter); 
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format");
        }
    }
}
