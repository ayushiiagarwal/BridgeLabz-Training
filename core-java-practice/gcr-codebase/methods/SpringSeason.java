import java.util.*;
public class SpringSeason {

    public static boolean season(int month, int day){
        if((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter month as number: ");
        int month = sc.nextInt();

        System.out.println("Enter day: ");
        int day = sc.nextInt();

        boolean result = season(month, day);
        System.out.println(result);

        sc.close();
    }
}
