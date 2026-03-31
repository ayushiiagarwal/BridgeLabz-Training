import java.util.*;

public class LowerCase {
    public static String toLower(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.nextLine();

        String result = toLower(text);
        String builtin = text.toLowerCase();
        System.out.println("Lowercase equal? " + compare(result, builtin));

        sc.close();
    }
}