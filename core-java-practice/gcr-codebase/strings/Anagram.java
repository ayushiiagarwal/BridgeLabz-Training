import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        String string1 = "listen";
        String string2 = "silent";

        char[] array1 = string1.toCharArray();
        char[] array2 = string2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        if (Arrays.equals(array1, array2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }
}