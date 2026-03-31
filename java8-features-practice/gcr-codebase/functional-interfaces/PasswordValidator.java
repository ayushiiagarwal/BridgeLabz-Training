import java.util.Scanner;

interface SecurityUtils{
    static boolean isStrong(String password){
        if(password.length() < 8) return false;

        boolean upper = false;
        boolean lower = false;
        boolean numbers = false;

        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c)) upper = true;
            else if(Character.isLowerCase(c)) lower = true;
            else if(Character.isDigit(c)) numbers = true;
        }

        return upper && lower && numbers;
    }
}

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password: ");
        String password = sc.next();

        if(SecurityUtils.isStrong(password))
            System.out.println("Strong Password!");
        else
            System.out.println("Weak Password");

        sc.close();
    }
}
