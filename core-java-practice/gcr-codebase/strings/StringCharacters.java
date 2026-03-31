import java.util.*;
public class StringCharacters {

    public static char[] characters(String text){
        char[] array = new char[text.length()];
        for(int i=0;i<text.length();i++){
            array[i] = text.charAt(i);
        }

        return array;
    }

    public static boolean compare(char[] a, char[] b){
        if(a.length != b.length) return false;
        for(int i=0;i<a.length;i++){
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.next();

        char[] charArray = characters(text);
        System.out.println("User defined Char Array: " + Arrays.toString(charArray));
        
        char[] builtIn = text.toCharArray();
        System.out.println("Built-in Char Array: " + Arrays.toString(builtIn));

        System.out.println("Equal? " + compare(charArray, builtIn));

        sc.close();
    }
}
