import java.util.Scanner;
public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int num1 = sc.nextInt();
        System.out.println("Enter the second number:");
        int num2 = sc.nextInt();
        System.out.println("Enter the third number:");
        int num3 = sc.nextInt();
        double average = (num1 + num2 + num3) / 3.0;
        System.out.println("Average = " + average);

        sc.close();
    }
}
