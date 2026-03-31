//Concatenate Strings using StringBuffer

public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] words = {"My", " name", " is", " Ayushi."};

        StringBuffer br = new StringBuffer();

        for(String s : words){
            br.append(s);
        }

        System.out.println("Concatenated String: " + br.toString());
    }
}
