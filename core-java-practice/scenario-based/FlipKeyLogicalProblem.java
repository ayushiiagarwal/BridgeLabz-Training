import java.util.*;

public class FlipKeyLogicalProblem {

    public static String cleanseAndInvert(String input){
        if(input == null || input.length() < 6 || !input.matches("^[a-zA-Z]+$"))
            return "Invalid Input"; //Input cannot be null.

        input.toLowerCase();

        String result = "";
        for(char c : input.toCharArray()){
            int ascii = (int) c;

            if(ascii % 2 != 0)
                result += c;
        }
        String reversed = new StringBuilder(result).reverse().toString();

        String formatted = "";
        for(int i=0;i<reversed.length();i++){
            char ch = reversed.charAt(i);

            if(i % 2 == 0)
                formatted += Character.toUpperCase(ch);
            else
                formatted = formatted + ch;
        }
        
        return "The generated key is - " + formatted;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input: ");
        String input = sc.next();
        System.out.println(cleanseAndInvert(input));

        sc.close();
    }
}
