// Find the factors of a number using for loop
import java.util.Scanner;
public class FactorsFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if(num <= 0){
            System.out.println("Enter a positive number");
            return;
        }
        System.out.println("Factors of " + num + " are:");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}
