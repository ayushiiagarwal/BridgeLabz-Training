import java.util.*;
public class VowelsAndConsonants{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.next();

        char[] ch = text.toCharArray();
        int vowels = 0;
        int consonants = 0;
        for(int i=0;i<=ch.length-1;i++){
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] =='o' || ch[i] == 'u' ||
                ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U')
                vowels++;

            else
                consonants++;
        }
        System.out.println("Number ofVowels: " + vowels);
        System.out.println("Number of Consonants: " + consonants);

        sc.close();
    }
}