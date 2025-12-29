import java.util.Scanner;
public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        checkPrime(num);
        
        sc.close();
    }

    public static void checkPrime(int num) {
        if (num <= 1) System.out.println("Not a Prime Number");
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) System.out.println("Not a Prime Number");
        }
        System.out.println("A Prime Number");
    }
}
