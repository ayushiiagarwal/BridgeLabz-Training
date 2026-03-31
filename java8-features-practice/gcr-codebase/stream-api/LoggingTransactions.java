import java.time.LocalDateTime;
import java.util.List;

public class LoggingTransactions {
    public static void main(String[] args) {
        List<String> transactionIds = List.of(
            "AA1254", "BB55151", "CC1515", "DD4654"
        );

        transactionIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}
