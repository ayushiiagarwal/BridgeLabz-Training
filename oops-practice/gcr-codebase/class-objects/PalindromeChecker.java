public class PalindromeChecker {
    String text;

    PalindromeChecker(String text){
        this.text = text;
    }

    public boolean isPalindrome(){
        String cleanText = text.replaceAll("\\s", "").toLowerCase();
        String reverse = new StringBuilder(cleanText).reverse().toString();

        return cleanText.equals(reverse);
    }

    public void result(){
        if(isPalindrome())
            System.out.println(text + " is Palindrome");

        else
            System.out.println(text + " is not Palindrome");
    }

    public static void main(String[] args) {
        PalindromeChecker check1 = new PalindromeChecker("A man a plan a canal Panama");
        check1.result();

        PalindromeChecker check2 = new PalindromeChecker("Hello");
        check2.result();

    }
}
