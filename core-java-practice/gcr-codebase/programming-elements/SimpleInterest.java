import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the principal amount:");
        double principal = sc.nextDouble();
        System.out.println("Enter the annual interest rate:");
        double rate = sc.nextDouble();
        System.out.println("Enter the time in years:");
        double time = sc.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest is " + simpleInterest);

        sc.close();
    }
}
