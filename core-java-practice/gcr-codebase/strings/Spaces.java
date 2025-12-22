import java.util.*;

public class Spaces {
    public static int[] findIndices(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;
        return new int[]{start, end + 1};
    }

    public static String getSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.nextLine();

        int[] indices = findIndices(str);
        String result = getSubstring(str, indices[0], indices[1]);
        String builtin = str.trim();

        System.out.println("User-defined trim: [" + result + "]");
        System.out.println("Built-in trim: [" + builtin + "]");

        System.out.println("Are they equal? " + compare(result, builtin));

        sc.close();
    }
}