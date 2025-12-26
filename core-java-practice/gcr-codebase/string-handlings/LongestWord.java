import java.util.*;
public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String sentence = sc.next();

        String[] words = sentence.split(" ");

        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        System.out.println("Longest Word: " + longest);

        sc.close();
    }
}
