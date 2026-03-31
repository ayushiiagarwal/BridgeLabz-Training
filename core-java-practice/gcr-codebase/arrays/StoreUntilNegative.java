import java.util.Scanner;
public class StoreUntilNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            if (index == 10) break;
            System.out.println("Enter the numbers (0 or negative to stop): ");
            double num = sc.nextDouble();
            if (num <= 0) 
                break;

            numbers[index++] = num;
        }

        for (int i = 0; i < index; i++) {
            total += numbers[i];
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nSum = " + total);

        sc.close();
    }
}
