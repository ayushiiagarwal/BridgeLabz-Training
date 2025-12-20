import java.util.Scanner;

public class MultiplyFrom6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int[] result = new int[10];

        for (int i = 6; i <= 9; i++) {
            result[i] = num * (i+1);
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        sc.close();
    }
}
