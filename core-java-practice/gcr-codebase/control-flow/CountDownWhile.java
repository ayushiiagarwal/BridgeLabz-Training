// count down the number using while loop

import java.util.Scanner;
public class CountDownWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        while (n >= 1) {
            System.out.println(n);
            n--;
        }

        sc.close();
    }
}
