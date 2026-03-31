import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface Date{
    static String format(LocalDate date, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class FormatDate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("dd-MM-yyyy -> " + Date.format(today, "dd-MM-yyyy"));
        System.out.println("MM dd, yyyy -> " + Date.format(today, "MM dd, yyyy"));
    }
}
