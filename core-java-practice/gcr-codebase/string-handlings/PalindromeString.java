// palindrome check

import java.util.*;
public class PalindromeString{
    public static void isPalindrome(String text){
        String reversed = "";
        for(int i=text.length()-1;i>=0;i--){
            reversed += text.charAt(i);
        }
        if(text.equals(reversed)) System.out.println("Palindrome String");

        else System.out.println("Not a Palindrome String");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.next();

        isPalindrome(text);

        sc.close();
    }
}