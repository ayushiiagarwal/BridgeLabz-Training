import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a date in the format YYYY-MM-DD: ");
        String inputDate = sc.nextLine();

        LocalDate date = LocalDate.parse(inputDate);
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2);
        LocalDate finalDate = newDate.minusWeeks(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println( finalDate.format(formatter));

        sc.close();
    }
}
