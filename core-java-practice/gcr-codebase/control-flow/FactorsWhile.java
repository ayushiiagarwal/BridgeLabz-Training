import java.util.Scanner;
public class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num > 0) {
            int i = 1;
            System.out.println("Factors of " + num + " are: ");
            while (i <= num) {
                if (num % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        } else {
            System.out.println("Invalid input.");
        }
        sc.close();
    }
}
