import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the principal amount:");
        double principal = scanner.nextDouble();
        System.out.println("Enter the annual interest rate:");
        double rate = scanner.nextDouble();
        System.out.println("Enter the time in years:");
        double time = scanner.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest is " + simpleInterest);

        scanner.close();
    }
}
