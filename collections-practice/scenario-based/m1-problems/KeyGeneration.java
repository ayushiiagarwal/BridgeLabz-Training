import java.util.*;

public class KeyGeneration {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();

            // 1. Validation
            if (input.length() == 0) {
                System.out.println("Invalid Input (empty string)");
                continue;
            }

            if (input.length() < 6) {
                System.out.println("Invalid Input (length < 6)");
                continue;
            }

            if (input.contains(" ")) {
                System.out.println("Invalid Input (contains space)");
                continue;
            }

            if (input.matches(".*\\d.*")) {
                System.out.println("Invalid Input (contains digits)");
                continue;
            }

            if (!input.matches("[a-zA-Z]+")) {
                System.out.println("Invalid Input (contains special character)");
                continue;
            }

            String str = input.toLowerCase();

            //remove even ASCII
            StringBuilder filtered = new StringBuilder();

            for (char ch : str.toCharArray()) {
                if ((int) ch % 2 != 0) {
                    filtered.append(ch);
                }
            }

            filtered.reverse();

            // uppercase at even index
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < filtered.length(); j++) {
                char ch = filtered.charAt(j);

                if (j % 2 == 0) {
                    result.append(Character.toUpperCase(ch));
                } else {
                    result.append(ch);
                }
            }

            System.out.println("The generated key is - " + result.toString());
        }

        sc.close();
    }
}