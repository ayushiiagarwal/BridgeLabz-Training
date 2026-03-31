import java.util.Scanner;

public class LeapYearLogical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = sc.nextInt();

        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Enter the years after 1582 only.");
        }
        sc.close();
    }
}
