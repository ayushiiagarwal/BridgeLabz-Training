import java.util.List;

public class TransformNames {
    public static void main(String[] args) {
        List<String> names = List.of("Shreyansh", "Ridansh", "Ayushi", "Rahul", "Arjun");

        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
