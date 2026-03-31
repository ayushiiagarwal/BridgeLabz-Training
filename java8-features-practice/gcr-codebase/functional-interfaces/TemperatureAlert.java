import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        double threshold = 50.0;

        Predicate<Double> alert = temp -> temp > threshold;

        double currentTemp = 40;

        if(alert.test(currentTemp))
            System.out.println("Temperature is above threshold!");

        else
            System.out.println("Temperature is Normal!");
    }
}
