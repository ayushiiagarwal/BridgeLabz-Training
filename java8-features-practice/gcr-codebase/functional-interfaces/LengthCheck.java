import java.util.Scanner;
import java.util.function.Function;

public class LengthCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message: ");
        String message = sc.nextLine();

        int limit = 10;

        Function<String, Integer> length = str -> str.length();
        int givenLength = length.apply(message);

        if(limit < givenLength)
            System.out.println("Message exceeds limit!");

        else
            System.out.println("Message is within limit!");

        sc.close();
    }
}
