import java.util.*;
public class NonRepeatingCharacters {
    public static char findFirstNonRepeatingCharacter(String text) {
        int[] count = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char chars = text.charAt(i);
            count[chars]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char chars = text.charAt(i);
            if (count[chars] == 1) {
                return chars;
            }
        }

        return '\0'; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char nonRepeatingCharacter = findFirstNonRepeatingCharacter(text);

        if (nonRepeatingCharacter != '\0') {
            System.out.println("First non-repeating character: " + nonRepeatingCharacter);
        } else {
            System.out.println("No non-repeating character found.");
        }
        sc.close();
    }
}
