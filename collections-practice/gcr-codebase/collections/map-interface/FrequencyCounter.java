import java.util.*;
public class FrequencyCounter{
    public static void main(String[] args) {
        String text = "Hello World, hello Java!";

        System.out.println("Input: " + text);

        text = text.toLowerCase().replaceAll("[^a-z]", " ");

        String[] words = text.split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        System.out.println("Output: " + map);
    }
}