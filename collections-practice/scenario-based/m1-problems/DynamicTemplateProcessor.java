import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicTemplateProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            Matcher matcher = Pattern.compile("\\$\\{(.*?):(.*?)\\}").matcher(line);

            StringBuffer result = new StringBuffer();

            while(matcher.find()){
                String type = matcher.group(1);
                String value = matcher.group(2);

                String replacement = process(type, value);

                matcher.appendReplacement(result, replacement);
            }

            matcher.appendTail(result);

            System.out.println(result.toString());
        }
        sc.close();
    }

    static String process(String type, String value){
        try{
            switch (type) {
                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "DATE":{
                    DateTimeFormatter input = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    DateTimeFormatter output = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate date = LocalDate.parse(value, input);
                    return date.format(output);
                }

                case "REPEAT":{
                    String[] parts = value.split(",");
                    String word = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<count;i++)
                        sb.append(word);

                    return sb.toString();
                }

                default:
                    return "INVALID";
            }
        }
        catch(Exception e){
            return "INVALID";
        }
    }
}
