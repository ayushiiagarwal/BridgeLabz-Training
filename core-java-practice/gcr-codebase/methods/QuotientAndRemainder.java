import java.util.*;
public class QuotientAndRemainder {

    public static void findRemainderAndQuotient(int dividend, int divisor){
        int quotient = dividend / divisor;
        System.out.println("Quotient: " + quotient);

        int remainder = dividend % divisor;
        System.out.println("Remainder: " + remainder);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the devidend: ");
        int dividend = sc.nextInt();

        System.out.println("Enter the divisor: ");
        int divisor = sc.nextInt();

        findRemainderAndQuotient(dividend, divisor);

        sc.close();
    }
}
