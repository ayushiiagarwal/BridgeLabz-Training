import java.util.Scanner;
public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of terms: : ");
        int terms = sc.nextInt();

        fibonacci(terms);

        sc.close();
    }

    public static void fibonacci(int num) {
        int a = 0, b = 1;
        for (int i = 0; i < num; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
