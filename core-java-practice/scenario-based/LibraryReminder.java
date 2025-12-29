import java.util.Scanner;
public class LibraryReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int fine = 5;
        int totalFine = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Book " + i + ":");

            System.out.print("Return Date (DD-MM-YYYY for the same month): ");
            String returnDate = sc.next();

            System.out.print("Due Date (DD-MM-YYYY for the same month): ");
            String dueDate = sc.next();

            String[] rtrn = returnDate.split("-");
            String[] due = dueDate.split("-");

            int r = Integer.parseInt(rtrn[0]);
            int d = Integer.parseInt(due[0]);
            
            if (r > d) {
                int daysLate = r - d;
                int bookFine = daysLate * fine;
                totalFine += bookFine;
                System.out.println("Fine for this book: Rs. " + bookFine);
            }
            else
                System.out.println("No Fine.");

        }

        System.out.println("Total Fine: Rs. " + totalFine);

        sc.close();
    }
}
