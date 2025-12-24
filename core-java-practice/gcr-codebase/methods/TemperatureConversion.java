import java.util.*;
public class TemperatureConversion {

    public static double farhenheitToCelcius(double farhenheit){
        return (farhenheit-32) * 5 / 9;
    }

    public static double celciusToFarhenheit(double tempCelcius){
        return (tempCelcius*9/5) + 32;
    }

    public static double poundsToKilograms(double pounds){
        return pounds*0.453592;
    }

    public static double kilogramsToPounds(double kg){
        return kg*2.20462;
    }

    public static double gallonsToLiters(double gallons){
        return gallons*3.78541;
    }

    public static double litersToGallons(double lt){
        return lt*0.264172;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperature in farhenheit: ");
        double farhenheit = sc.nextDouble();
        double celcius = farhenheitToCelcius(farhenheit);
        System.out.println(farhenheit + " farhenheit = " + celcius + " celcius");

        System.out.println("Enter temperature in celcius: ");
        double tempCelcius = sc.nextDouble();
        double f = celciusToFarhenheit(tempCelcius);
        System.out.println(tempCelcius + " celcius = " + f + " farhenheit");

        System.out.println("Enter quantity in pounds: ");
        double pounds = sc.nextDouble();
        double kilograms = poundsToKilograms(pounds);
        System.out.println(pounds + " pounds = " + kilograms + " kilograms");

        System.out.println("Enter quantity in kilograms: ");
        double kg = sc.nextDouble();
        double p = kilogramsToPounds(kg);
        System.out.println(kg + " kilograms = " + p + " pounds");

        System.out.println("Enter quantity in gallons: ");
        double gallons = sc.nextDouble();
        double liters = gallonsToLiters(gallons);
        System.out.println(gallons + " gallons = " + liters + " liters");

        System.out.println("Enter quantity in liters: ");
        double lt = sc.nextDouble();
        double gl = litersToGallons(lt);
        System.out.println(lt + " kilograms = " + gl + " gallons");

        sc.close();
    }
}
