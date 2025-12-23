import java.util.*;
public class SplitText2D {

    public static String[] splitIntoWords(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() > 0) {
            words.add(sb.toString());
        }

        return words.toArray(new String[0]);
    }

    public static String[][] length(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.nextLine();

        String[] words = splitIntoWords(text);
        String[][] result = length(words);
        System.out.printf("%-15s %-10s%n", "Word", "Length");
        for (String[] row : result) {
            System.out.printf("%-15s %-10d%n", row[0], Integer.parseInt(row[1]));
        }

        sc.close();
    }
    
}
