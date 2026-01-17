// remove duplicates from a strig using string builder
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (!seen.contains(ch)) {
                sb.append(ch);   
                seen.add(ch);        
            }
        }
        System.out.println(sb.toString());
    }    
}
