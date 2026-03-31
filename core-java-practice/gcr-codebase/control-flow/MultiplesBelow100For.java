import java.util.Scanner;

public class MultiplesBelow100For {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num > 0 && num < 100) {
            for (int i = 100; i >= 1; i--) {
                if (i % num == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Invalid input.");
        }
        sc.close();
    }
}
