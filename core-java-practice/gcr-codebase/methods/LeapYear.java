import java.util.*;
public class LeapYear {

    public static boolean getLeapYear(int year){
        if(year >= 1582) {
            if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return true;
            else return false;
        }
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an year: ");
        int year = sc.nextInt();

        boolean result = getLeapYear(year);
        System.out.println(result);

        sc.close();
    }
}
