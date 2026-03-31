import java.util.*;
public class FrequencyUsingUniqueChars {
    public static int[][] charFrequencyUsingUniqueChars(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char chars = text.charAt(i);
            frequency[chars]++;
        }

        char[] chars = UniqueCharacters.findUniqueCharacters(text);

        int[][] charFreq = new int[chars.length][2];
        for (int i = 0; i < chars.length; i++) {
            charFreq[i][0] = chars[i];
            charFreq[i][1] = frequency[chars[i]];
        }

        return charFreq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int[][] characterFrequencies = charFrequencyUsingUniqueChars(text);

        System.out.println("Character Frequencies using Unique Characters:");
        for (int i = 0; i < characterFrequencies.length; i++) {
            System.out.println((char)characterFrequencies[i][0] + ": " + characterFrequencies[i][1]);
        }
        sc.close();
    }
}
