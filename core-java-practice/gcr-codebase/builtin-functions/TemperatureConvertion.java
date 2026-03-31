import java.util.Scanner;
public class TemperatureConvertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperature in celcius: ");
        double celsius = sc.nextDouble();

        System.out.println("Enter temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();

        System.out.print(celciusToFahrenheit(celsius) + " Fahrenheit " + fahrenheitToCelcius(fahrenheit) + " Celcius ");

        sc.close();
    }

    public static double celciusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelcius(double f) {
        return (f - 32) * 5 / 9;
    }
}
