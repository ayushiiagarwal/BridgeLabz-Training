import java.util.Scanner;
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, sum;
        System.out.println("Enter first number:"); 
        num1 = sc.nextInt();
        System.out.println("Enter second number:");     
        num2 = sc.nextInt();
        sum = num1 + num2;
        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);

        sc.close();
    }
}