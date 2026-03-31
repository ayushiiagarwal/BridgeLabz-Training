import java.util.Scanner;
public class CompareSumOfNaturalNumbersFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int formula = num * (num + 1) / 2;
        int loop = 0;
        for (int i = 1; i <= num; i++) {
            loop += i;
        }

        System.out.println("Sum using formula: " + formula);
        System.out.println("Sum using for loop: " + loop);

        sc.close();
    }
}
