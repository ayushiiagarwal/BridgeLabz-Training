public class PasswordValidator {
    public boolean isValid(String password) {

        if (password.length() < 8) return false;
        boolean upper = false;
        boolean digit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch))
            	upper = true;
            if (Character.isDigit(ch))
            	digit = true;
        }
        return upper && digit;
    }
}