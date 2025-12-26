import java.util.*;
public class SubstringOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String text = sc.next();
        
        String substring = sc.next();
        
        int count = 0;
        for (int i = 0; i <= text.length() - substring.length(); i++) {
            if (text.substring(i, i + substring.length()).equals(substring)) count++;
        }
        System.out.println("Occurrences: " + count);

        sc.close();
    }
}
