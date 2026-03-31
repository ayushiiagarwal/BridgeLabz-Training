import java.util.List;

public class EmailNoti {
    public static void main(String[] args) {
        List<String> emails = List.of(
            "ayushi@gmail.com", "alankrati@gmail.com", "shruti@gmail.com"
        );

        emails.forEach(email -> sendEmailNotification(email));

    }

    public static void sendEmailNotification(String email){
        System.out.println("Notification at: " + email);
    }
}
