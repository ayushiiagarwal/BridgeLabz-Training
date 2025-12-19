import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number and power: ");
        int num = sc.nextInt();
        int power = sc.nextInt();

        if (num >= 0 && power >= 0) {
            int result = 1;
            int i = 0;

            while (i < power) {
                result *= num;
                i++;
            }
            System.out.println("Result: " + result);
        } else {
            System.out.println("Only positive integers.");
        }
        sc.close();
    }
}
