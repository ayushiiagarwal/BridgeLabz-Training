import java.util.*;
public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.println("Enter second string: ");
        String str2 = sc.nextLine();

        boolean result = compare(str1, str2);
        System.out.println(result);

        boolean builtIn = str1.equals(str2);
        System.out.println(builtIn);

        sc.close();
    }

    public static boolean compare(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}