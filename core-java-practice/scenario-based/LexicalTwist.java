import java.util.*;

public class LexicalTwist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first word: ");
        String word1 = sc.nextLine();

        if (invalidWord(word1))
            System.out.println(word1 + " is an invalid word.");
        
        else{
            System.out.print("Enter the second word: ");
            String word2 = sc.nextLine();

            if (invalidWord(word2))
                System.out.println(word2 + " is an invalid word.");
        
            else if (isReverse(word1, word2)) {
                String result = replaceVowels(word1);
                System.out.println(result);
            } 
            else 
                concatenate(word1, word2);
        }
        sc.close();
    }

    public static boolean invalidWord(String word) {
        return word.contains(" ");
    }

    public static boolean isReverse(String word1, String word2) {
        String reversed = new StringBuilder(word1).reverse().toString();
        return reversed.equalsIgnoreCase(word2);
    }

    public static String replaceVowels(String word) {
        String reversed = new StringBuilder(word).reverse().toString().toLowerCase();
        return reversed.replaceAll("[aeiou]", "@");
    }

    public static void concatenate(String word1, String word2) {
        String combined = (word1 + word2).toUpperCase();

        int vowels = 0;
        int cons = 0;

        for (char ch : combined.toCharArray()) {
            if (isVowel(ch)) 
                vowels++;
            
            else 
                cons++;
            
        }

        if (vowels > cons)
            printFirstTwoUnique(combined, true);
        
        else if (cons > vowels)
            printFirstTwoUnique(combined, false);
        
        else 
            System.out.println("Vowels and consonants are equal");

    }

    public static boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    public static void printFirstTwoUnique(String word, boolean vowels) {
        Set<Character> set = new LinkedHashSet<>();

        for (char ch : word.toCharArray()) {
            if (vowels && isVowel(ch)) 
                set.add(ch); 

            else if (!vowels && !isVowel(ch)) 
                set.add(ch);

            if (set.size() == 2)
                break;

        }

        for (char ch : set) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
