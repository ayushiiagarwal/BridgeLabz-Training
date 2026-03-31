import java.util.Scanner;
public class CompareSumOfNaturalNumbersWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int formula = number * (number + 1) / 2;
        int loop = 0;
        int i = 1;
        while (i <= number) {
            loop += i;
            i++;
        }

        System.out.println("Sum using formula: " + formula);
        System.out.println("Sum using while loop: " + loop);
        sc.close();
    }
}
