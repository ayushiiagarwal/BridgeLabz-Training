import java.util.Scanner;
public class SumUntil0 {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double total = 0.0;
    
    System.out.println("Enter the numbers: ");
    double input;

    while ((input = sc.nextDouble())!= 0) {
        total += input;
    }
    System.out.println("Total sum is: " + total);
    sc.close();
   } 
}
