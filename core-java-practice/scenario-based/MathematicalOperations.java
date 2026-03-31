import java.util.Scanner;
public class MathematicalOperations {

    public static void factorial(int num){
        int fact = 1;
        if(num > 0){
            for(int i=1;i<=num;i++){
                fact *= i;
            }
            System.out.println("Factorial: " + fact);
        }
        else
            System.out.println("Invalid number");
    }

    public static void prime(int num){
        if(num < 2){
            System.out.println(num + " is Not a Prime Number");
            return;
        }

        for(int i=2;i<num;i++){
            if(num % i == 0){
                System.out.println(num + " is not Prime Number");
                return;
            }
        }
            System.out.println(num + " is a Prime Number");
    }

    public static void gcd(int num1, int num2){
        int a = num1;
        int b = num2;

        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        System.out.println("The GCD of " + a + " and " + b + " is: " + num1);
    }

    public static void fibonacci(int n){
        int x = 0, y = 1, next = 0;
        for(int i=2;i<n;i++){
            next = x+y;
            x = y;
            y = next;
        }
        System.out.println(n + "th Fibonacci number is: " + next);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number to calculate the factorial: ");
        int fact = sc.nextInt();
        factorial(fact);

        System.out.println("Enter a number to check prime number: ");
        int num = sc.nextInt();
        prime(num);

        System.out.println("Enter the two numbers to calculate GCD: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        gcd(num1, num2);

        System.out.println("Enter a number to find nth fibonacci number: ");
        int n = sc.nextInt();
        fibonacci(n);

        sc.close();
    }
}
