import java.util.*;
public class StringLength {
    public static int length(String text) {
        int count = 0;
        try {
            while (true) text.charAt(count++);
        } catch (Exception e) {}
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        System.out.println("Length(user-defined): " + length(text));
        System.out.println("Built-in length: " + text.length());

        sc.close();
    }
}