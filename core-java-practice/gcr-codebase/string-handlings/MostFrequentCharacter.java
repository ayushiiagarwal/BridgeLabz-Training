public class MostFrequentCharacter {
    public static void main(String[] args) {
        String s = "success";

        int[] frequency = new int[256];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i)]++;
        }

        int max = 0;
        char result = ' ';

        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i)] > max) {
                max = frequency[s.charAt(i)];
                result = s.charAt(i);
            }
        }
        System.out.println("Most Frequent Character: " + "'" + result + "'");
    }
    
}
