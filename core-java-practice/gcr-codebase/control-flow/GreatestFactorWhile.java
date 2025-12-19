import java.util.Scanner;
public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int greatestFactor = 1;
        int i = num - 1;

        while (i >= 1) {
            if (num % i == 0) {
                greatestFactor = i;
                break;
            }
            i--;
        }
        System.out.println("Greatest factor: " + greatestFactor);
    }
}
