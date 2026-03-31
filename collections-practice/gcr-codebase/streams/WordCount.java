import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> count = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        count.put(word, count.getOrDefault(word, 0) + 1);
                    }
                }
            }

            count.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        } catch (IOException e) {
            System.out.println("Failed to read file.");
        }
    }
}