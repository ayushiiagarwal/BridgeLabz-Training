import java.util.*;
public class SplitText{
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count++);
            }
        } catch (Exception e) {}
        return count;
    }

    public static String[] split(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getLength(text); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                words.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        words.add(sb.toString());
        return words.toArray(new String[0]);
    }

    public static boolean compare(String[] str1, String[] str2) {
        if (str1.length != str2.length) return false;

        for (int i = 0; i < str1.length; i++) {
            if (!str1[i].equals(str2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();

        String[] custom = split(text);
        String[] builtin = text.split(" ");
        System.out.println(compare(custom, builtin));

        sc.close();
    }
}