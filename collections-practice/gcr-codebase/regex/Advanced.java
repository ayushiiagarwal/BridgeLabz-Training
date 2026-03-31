import java.util.*;
import java.util.regex.*;

public class Advanced {

    public static boolean validateIP(String ip){
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        return ip.matches(regex);
    }

    public static boolean validateCreditCard(String card) {
        String visa = "^4\\d{15}$";
        String master = "^5\\d{15}$";
        return card.matches(visa) || card.matches(master);
    }

    public static List<String> extractLanguages(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
        while (m.find()) result.add(m.group());
        return result;
    }

    public static List<String> extractCurrency(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = Pattern.compile("\\$\\d+(\\.\\d{2})?|\\d+\\.\\d{2}").matcher(text);
        while (m.find()) result.add(m.group());
        return result;
    }

    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeats = new HashSet<>();
        Matcher m = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE).matcher(text);
        while (m.find()) repeats.add(m.group(1));
        return repeats;
    }

    public static boolean validateSSN(String text) {
        String regex = ".*\\b\\d{3}-\\d{2}-\\d{4}\\b.*";
        return text.matches(regex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();

        System.out.println(validateIP(ip) ? "Valid" : "Invalid");

        System.out.println("Enter text to validate Credit Card: ");
        String card = sc.nextLine();

        System.out.println(validateCreditCard(card) ? "Valid" : "Invalid");

        System.out.println("Enter text to extract programming languages: ");
        String text = sc.nextLine();

        System.out.println(extractLanguages(text));

        System.out.println("Enter text to extract Currency: ");
        String currency = sc.nextLine();

        System.out.println(extractCurrency(currency));

        System.out.println("Enter text to find repeated words: ");
        String text2 = sc.nextLine();

        System.out.println(findRepeatingWords(text2));

        System.out.println("Enter text to validate SSN Number: ");
        String ssn = sc.nextLine();

        System.out.println(validateSSN(ssn) ? "Valid" : "Invalid");

        sc.close();
    }
}
