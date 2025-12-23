import java.util.*;
public class Frequency {
    public static int[][] charFrequency(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char chars = text.charAt(i);
            freq[chars]++;
        }

        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }

        int[][] charFreq = new int[count][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                charFreq[index][0] = i;
                charFreq[index][1] = freq[i];
                index++;
            }
        }

        return charFreq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int[][] characterFrequencies = charFrequency(text);

        System.out.println("Character Frequencies:");
        for (int i = 0; i < characterFrequencies.length; i++) {
            System.out.println((char)characterFrequencies[i][0] + ": " + characterFrequencies[i][1]);
        }
        sc.close();
    }
}
