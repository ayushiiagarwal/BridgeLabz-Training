import java.util.*;
public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String word = sc.next();
        String replace = "Python";

        String modified = sentence.replace(word, replace);
        System.out.println("Modified Sentence: " + modified);

        sc.close();
    }
    
}
