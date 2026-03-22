import java.util.*;

public class DocumentRedactionEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            System.out.println(processLine(line));
        }

        sc.close();
    }

    static String processLine(String input){
        input = input.replaceAll("ID:[A-Z]{3}[0-9]{6}", "ID:XXX******");

        input = input.replaceAll("ACCT-[0-9]{4}-[0-9]{4}-([0-9]{4})", "ACCT---$1");

        input = input.replaceAll("(?i)\\b(\\w+)\\s+\\1\\b", "$1");

        input = input.replaceAll("([!?\\.])\\1{2,}$", "$1");

        return input;
    }
}
