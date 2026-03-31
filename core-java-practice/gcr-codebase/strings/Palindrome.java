public class Palindrome {

    static boolean logic1(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    static boolean logic2(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return logic2(s, i + 1, j - 1);
    }

    static boolean logic3(String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length / 2; i++)
            if (a[i] != a[a.length - i - 1]) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(logic1(s));
        System.out.println(logic2(s, 0, s.length() - 1));
        System.out.println(logic3(s));
    }
}