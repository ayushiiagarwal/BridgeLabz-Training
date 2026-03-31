import java.util.Scanner;
public class SentenceFormatter{

    public static String formattedParagraph(String text){
        if(text == null || text.isBlank()) return "";

        String formatted = text.trim().replaceAll("\\s+", " ");

        StringBuilder result = new StringBuilder();
        boolean capitalize = true;

        char[] chars = formatted.toCharArray();

        for(int i=0;i<chars.length;i++){
            char current = chars[i];

            if(capitalize && Character.isLetter(current)){
                result.append(Character.toUpperCase(current));
                capitalize = false;
            }
            else
                result.append(current);

            if(current == '.' || current == '!' || current == '?' || current == ','){
                if(i <formatted.length()-1 && !Character.isWhitespace(formatted.charAt(i+1))){
                    result.append(' ');
                }
                capitalize=true;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph: ");
        String input = sc.nextLine();

        String result = formattedParagraph(input);
        System.out.println("\nFormatted Paragraph:\n" + result);

        sc.close();
    }
}