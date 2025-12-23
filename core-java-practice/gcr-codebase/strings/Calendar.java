import java.util.*;

public class Calendar {

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    static int firstDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + 31 * m0 / 12) % 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt(), year = sc.nextInt();

        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (month == 2 && isLeap(year)) days[1] = 29;

        System.out.println(months[month-1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int start = firstDay(month, year);
        for (int i = 0; i < start; i++) System.out.print("    ");

        for (int d = 1; d <= days[month-1]; d++) {
            System.out.printf("%3d ", d);
            if ((d + start) % 7 == 0) System.out.println();
        }

        sc.close();
    }
}