// Perimeter of a square
import java.util.Scanner;
public class PerimeterOfSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side of the square: ");
        int side = sc.nextInt();
        int perimeter = side * 4;
        System.out.println("The length of the side is " + side + " whose parimeter is " + perimeter);
        sc.close();
    }
}
