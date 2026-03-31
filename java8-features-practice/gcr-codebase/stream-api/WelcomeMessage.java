import java.util.List;

public class WelcomeMessage {
    public static void main(String[] args) {
        List<String> attendees = List.of("Rahul", "Ayushi", "Shreyansh", "Aanvi", "Nitya");

        attendees.stream()
        .forEach(person -> System.out.println("Welcome " + person + "!"));
    }
}
