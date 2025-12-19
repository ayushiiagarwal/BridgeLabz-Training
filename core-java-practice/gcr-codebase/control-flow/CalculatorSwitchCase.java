import java.util.Scanner;

public class CalculatorSwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double first = sc.nextDouble();

        System.out.println("Enter the second number:");
        double second = sc.nextDouble();

        System.out.println("Enter the operator: ");
        String operator = sc.next();
        switch (operator) {
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "*":
                System.out.println(first * second);
                break;
            case "/":
                System.out.println(first / second);
                break;
            default:
                System.out.println("Invalid Operator");
        }

        sc.close();
    }
}
