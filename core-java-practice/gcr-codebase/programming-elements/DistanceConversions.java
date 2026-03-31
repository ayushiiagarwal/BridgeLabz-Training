// Convert feet to yards and miles
import java.util.Scanner;
public class DistanceConversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the distance in feets: ");
        int distance = sc.nextInt();

        double yards = distance / 3.0;
        double miles = distance / 5280.0;

        System.out.println("The distance in feet is " + distance + " while in yards is " + yards + " and in miles is " + miles);

        sc.close();
    }
}
