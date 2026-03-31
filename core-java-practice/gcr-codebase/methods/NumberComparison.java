import java.util.*;

public class NumberComparison {

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int first, int last) {
        if (first > last) return 1;
        if (first < last) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter five numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            System.out.print("Number " + current + " is: ");

            if (isPositive(current)) {
                System.out.print("Positive and ");
                if (isEven(current)) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else if (current == 0) {
                System.out.println("Zero");
            } else {
                System.out.println("Negative");
            }
        }

        int result = compare(numbers[0], numbers[numbers.length - 1]);
        if (result == 1)
            System.out.println("First element is greater than last.");
        else if (result == -1)
            System.out.println("First element is less than last.");
        else
            System.out.println("First and last elements are equal.");

        sc.close();
    }
}