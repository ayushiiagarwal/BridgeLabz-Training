// Find the age of Harry if his birth year is 2000.
import java.util.Scanner;
public class AgeOfHarry {
    public static void main(String[] args) {
        int birthYear = 2000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the current Year:");
        int currentYear = sc.nextInt();
        
        int harrysAge = currentYear - birthYear;
        System.out.println("Harry's age is: " + harrysAge);
        
        sc.close();
    }
}
