import java.util.*;
public class Validate {

    public static boolean validateUsername(String username){
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(regex);
    }

    public static boolean validateLicense(String number){
        String regex = "^[A-Z]{2}\\d{4}$";
        return number.matches(regex);
    }

    public static boolean validateColor(String color){
        String regex = "^[#][A-fa-f0-9]{6}$";
        return color.matches(regex);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = sc.next();

        System.out.println(validateUsername(username) ? "Valid" : "Invalid");

        System.out.println("Enter License Plate Number: ");
        String number = sc.next();

        System.out.println(validateLicense(number) ? "Valid" : "Invalid");

        System.out.println("Enter Hex Color: ");
        String color = sc.next();

        System.out.println(validateColor(color) ? "Valid" : "Invalid");

        sc.close();
    }
}