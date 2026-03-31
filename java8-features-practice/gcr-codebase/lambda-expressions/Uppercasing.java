import java.util.List;

public class Uppercasing {
    public static void main(String[] args) {
        List<String> names = List.of("ayushi", "alankrati", "shruti");

        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }    
}
