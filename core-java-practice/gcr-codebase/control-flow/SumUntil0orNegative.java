import java.util.Scanner;

public class SumUntil0orNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double total = 0;

        while (true) {
            System.out.println("Enter a number: ");
            double input = sc.nextDouble();
            if (input <= 0) break;
            total += input;
        }
        System.out.println("Total sum is: " + total);
        
        sc.close();
    }
}
