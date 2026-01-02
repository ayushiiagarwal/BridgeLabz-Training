import java.util.Scanner;
public class TextAnalyzer {

    public static int countWords(String text){
        if(text.isEmpty()) return 0;
        String[] words = text.split(" ");
        return words.length;

    }

    public static String longestWord(String text){
        if(text.isEmpty()) return "No Longest Word";

        String[] words = text.replaceAll("[^a-zA-Z]", " ").split(" ");
        String longest = "";
        for(String word : words){
            if(word.length() > longest.length())
                longest = word;
        }
        return longest;
    }

    public static String replaceOccurences(String text, String target, String replacement) {
        return text.replaceAll("(?i)" + target, replacement);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph: ");
        String paragraph = sc.nextLine();

        if(paragraph == null || paragraph.isEmpty()){
            System.out.println("Empty paragraph");
        }

        String formatted = paragraph.trim().replaceAll("\\s+", " ");

        System.out.println("Word Count: " + countWords(formatted));
        System.out.println("Longest Word: " + longestWord(formatted));
        
        System.out.println("Enter the word to be replaced: ");
        String word = sc.next();

        System.out.println("Enter the replacement word: ");
        String replaceWord = sc.next();

        System.out.println("Modified Text: \n" + replaceOccurences(formatted, word, replaceWord));

        sc.close();
    }
}
