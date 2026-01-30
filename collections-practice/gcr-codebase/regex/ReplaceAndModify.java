import java.util.*;
import java.util.regex.*;

public class ReplaceAndModify {

    public static String replaceSpaces(String text){
        return text.replaceAll("\\s+", " ").trim();
    }

    public static String censorWords(String text, List<String> badWords){
        for(String bad : badWords)
            text = text.replaceAll("(?i)\\b" + Pattern.quote(bad) + "\\b", "****");

        return text;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to Replace multiple spaces: ");
        String text1 = sc.nextLine();

        System.out.println(replaceSpaces(text1));

        System.out.println("Enter text to censor bad words: ");
        String text2 = sc.nextLine();
        List<String> badWords = Arrays.asList("damn", "stupid");

        System.out.println(censorWords(text2, badWords));

        sc.close();
    }
}
