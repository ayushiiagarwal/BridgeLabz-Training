import java.util.*;
import java.util.regex.*;

public class Extract {

    public static List<String> extractMail(String text){
        List<String> emails = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static List<String> extractCapital(String text){
        List<String> capitals = new ArrayList<>();
        String regex = "\\b[A-Z][a-z]*\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            capitals.add(matcher.group());
        }

        return capitals;
    }

    public static List<String> extractDates(String text){
        List<String> dates = new ArrayList<>();
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static List<String> extractLinks(String text){
        List<String> links = new ArrayList<>();
        String regex = "\\bhttps?://[a-zA-Z0-9._]+(?:\\.[a-zA-Z]{2,})+\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to extract Email Address: ");
        String text1 = sc.nextLine();

        System.out.println(extractMail(text1));

        System.out.println("Enter text to Extract Capital Words: ");
        String text2 = sc.nextLine();

        System.out.println(extractCapital(text2));

        System.out.println("Enter text to Extract Dates: ");
        String text3 = sc.nextLine();

        System.out.println(extractDates(text3));

        System.out.println("Enter text to extract Links: ");
        String text4 = sc.nextLine();

        System.out.println(extractLinks(text4));

        sc.close();
    }
}
