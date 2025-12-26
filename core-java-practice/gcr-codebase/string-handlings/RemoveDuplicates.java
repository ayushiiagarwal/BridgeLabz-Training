import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.next();

        String result = "";
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(result.indexOf(ch) == -1){
                result += ch;
            }
        }
        System.out.println("Modified string: " + result);

        sc.close();
    }
}
