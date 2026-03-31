import java.util.Scanner;
public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Invalid input!");
            return;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + num + " is: " + factorial);

        sc.close();
    }
}
