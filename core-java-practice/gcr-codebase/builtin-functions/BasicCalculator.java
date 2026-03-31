import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println("Enter the operator: ");
        char operator = sc.next().charAt(0);

        int result = switch (operator) {
            case '+' -> add(num1, num2);
            case '-' -> subtract(num1, num2);
            case '*' -> multiply(num1, num2);
            case '/' -> divide(num1, num2);
            default -> 0;
        };
        System.out.print(result);
        sc.close();
    }

    public static int add(int num1, int num2) { 
        return num1 + num2; 
    }

    public static int subtract(int num1, int num2) { 
        return num1 - num2; 
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2; 
    }

    public static int divide(int num1, int num2) {
        return num2 != 0 ? num1 / num2 : 0; 
    }
}
