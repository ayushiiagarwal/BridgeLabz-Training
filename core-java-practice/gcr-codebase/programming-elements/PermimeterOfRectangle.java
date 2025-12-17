import java.util.*;
public class PermimeterOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the rectangle:");
        int length = scanner.nextInt();
        System.out.println("Enter the width of the rectangle:");
        int width = scanner.nextInt();
        int perimeter = 2 * (length + width);
        System.out.println("Perimeter of rectangle is: " + perimeter);
    }
}
