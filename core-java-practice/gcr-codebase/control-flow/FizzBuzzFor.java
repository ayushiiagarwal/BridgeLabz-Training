// check for positive number, if positive, loop and print the number but for multiples of 3
// print Fuzz instead of number, for multiples of 5 print Buzz and for multiples of both, print FizzBuzz

import java.util.Scanner;
public class FizzBuzzFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int num = sc.nextInt();

        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                if (i % 3 == 0 && i % 5 == 0)
                    System.out.println("FizzBuzz");
                else if (i % 3 == 0)
                    System.out.println("Fizz");
                else if (i % 5 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(i);
            }
        } else {
            System.out.println("Not a positive integer.");
        }

        sc.close();
    }
}
