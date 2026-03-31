import java.util.*;
import java.util.stream.Collectors;

public class FrequencyCount {
    public static void main(String[] args) {
        String para = "My name is Ayushi and her name is Alankrati and her name is Shruti";

        Map<String, Integer> count = Arrays.stream(para.toLowerCase()
                                    .split("\\s+"))
                                    .collect(Collectors.toMap(word -> word,
                                            word -> 1, Integer::sum)
                                    );
        
        count.forEach((word, c) -> System.out.println(word + " - count: " + c));
    }
}
