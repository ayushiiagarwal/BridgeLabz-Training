import java.util.List;

public class IOTSensor {
    public static void main(String[] args) {
        List<Double> readings = List.of(21.5, 15.2, 95.3, 45.2, 51.0, 45.8);

        double threshold = 50.0;

        readings.stream()
        .filter(reading -> reading > threshold)
        .forEach(reading -> System.out.println("Readings above " + threshold + ": " + reading));
    }
}
