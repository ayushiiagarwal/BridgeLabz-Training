import java.util.*;
public class NumberChecker2 {
    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) if (num % i == 0) sum += i;
        return sum == num;
    }

    public static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) if (num % i == 0) sum += i;
        return sum > num;
    }

    public static boolean isDeficient(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) if (num % i == 0) sum += i;
        return sum < num;
    }

    public static boolean isStrong(int num) {
        int sum = 0, temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }

    private static int factorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Perfect: " + isPerfect(num));
        System.out.println("Abundant: " + isAbundant(num));
        System.out.println("Deficient: " + isDeficient(num));
        System.out.println("Strong: " + isStrong(num));

        sc.close();
    }
}