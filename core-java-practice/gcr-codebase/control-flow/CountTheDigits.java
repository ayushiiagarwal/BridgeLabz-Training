import java.util.Scanner;

public class CountTheDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt(), count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        System.out.println(count);

        sc.close();
    }
}
