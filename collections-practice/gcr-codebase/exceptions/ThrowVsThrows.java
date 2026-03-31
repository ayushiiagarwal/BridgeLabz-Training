import java.util.*;
public class ThrowVsThrows {

    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
        if(amount < 0 || rate < 0)
            throw new IllegalArgumentException();

        return (amount * rate * years) / 100;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter rate: ");
            double rate = sc.nextDouble();

            System.out.print("Enter years: ");
            int years = sc.nextInt();

            System.out.println("Interest: " + calculateInterest(amount, rate, years));

            sc.close();
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid Input: Amount and Rate must be positive.");
        }
    }
}
