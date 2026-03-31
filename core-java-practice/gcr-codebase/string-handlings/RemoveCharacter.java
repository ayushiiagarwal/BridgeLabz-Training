public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char ch = 'l';

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) result += str.charAt(i);
        }
        System.out.println("Modified String: " + result);
    }
}
