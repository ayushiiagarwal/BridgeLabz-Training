import java.util.*;
public class Substring {

    public static String getSubstring(String text, int start, int end){
        StringBuilder string = new StringBuilder();
        for(int i=start;i<end;i++){
            string.append(text.charAt(i));
        }
        return string.toString();
    }

    public static boolean compare(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.next();

        System.out.println("Enter the starting index: ");
        int start = sc.nextInt();

        System.out.println("Enter the ending index: ");
        int end = sc.nextInt();

        String result = getSubstring(text, start, end);
        String builtIn = text.substring(start, end);

        System.out.println("Result Substring: " + result);
        System.out.println("Built-in Substring: " + builtIn);

        System.out.println("Substrings Equal? " + compare(result, builtIn));

        sc.close();
    }    
}
