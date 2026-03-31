import java.util.*;
public class NumberException {

    public static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }

    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Caught you!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter a string: ");
        String text = sc.next();
        try {
            generateException(text);
        } catch (Exception e) {
            handleException(text);
        }

        sc.close();
    }
}
