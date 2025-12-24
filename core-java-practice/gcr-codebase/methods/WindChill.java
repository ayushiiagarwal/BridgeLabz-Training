import java.util.*;
public class WindChill {

    public static double calculateWindChill(double temperature, double windSpeed){
        double windChillTemperature = 35.74 + (0.6215 * temperature) + ((0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16));
        return windChillTemperature;
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the tenperature: ");
        double temperature = sc.nextDouble();

        System.out.println("Enter wind speed: ");
        double windSpeed = sc.nextDouble();

        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.println("Wind Chill: " + windChill);

        sc.close();
    }
}
