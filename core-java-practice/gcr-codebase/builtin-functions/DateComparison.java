import java.time.LocalDate;
import java.util.Scanner;
public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date in the format YYYY-MM-DD: ");
        String input1 = sc.nextLine();
        LocalDate date1 = LocalDate.parse(input1);

        System.out.println("Enter date in the format YYYY-MM-DD: ");
        String input2 = sc.nextLine();
        LocalDate date2 = LocalDate.parse(input2);

        if(date1.isBefore(date2)) 
            System.out.println(input1 + " is before " + input2);

         else if(date1.isAfter(date2))
            System.out.println(input1 + " is after " + input2);

         else 
            System.out.println("Both are same");

        sc.close();
    }
}
