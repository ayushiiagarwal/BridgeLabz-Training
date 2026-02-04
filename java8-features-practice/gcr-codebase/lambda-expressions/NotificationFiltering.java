import java.util.List;
import java.util.function.Predicate;

class Alert{
    String type;

    Alert(String type){
        this.type = type;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        
        List<Alert> alerts = List.of(
            new Alert("Critical"),
            new Alert("Normal"),
            new Alert("Info")
        );

        Predicate<Alert> criticalOnly = alert -> alert.type.equalsIgnoreCase("Critical");

        alerts.stream().filter(criticalOnly).forEach(a -> System.out.println(a.type));
    }
}
