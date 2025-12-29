import java.util.Scanner;
public class MaximumNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter three numbers: ");
        int num1 = getInput(sc);
        int num2 = getInput(sc);
        int num3 = getInput(sc);

        int maximum = findMax(num1, num2, num3);
        System.out.print("The maximum number is: " + maximum);

    }

    public static int getInput(Scanner scanner) {
        return scanner.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
