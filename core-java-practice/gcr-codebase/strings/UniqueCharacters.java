import java.util.*;
public class UniqueCharacters {
    public static int findLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            length++;
        }
        return length;
    }

    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);
        char[] chars = new char[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < count; j++) {
                if (chars[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                chars[count] = currentChar;
                count++;
            }
        }

        char[] result = new char[count];
        for (int k = 0; k < count; k++) {
            result[k] = chars[k];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputText = sc.nextLine();

        char[] uniqueCharacters = findUniqueCharacters(inputText);

        System.out.print("Unique characters: ");
        for (char c : uniqueCharacters) {
            System.out.print(c + " ");
        }
        sc.close();
    }
}
