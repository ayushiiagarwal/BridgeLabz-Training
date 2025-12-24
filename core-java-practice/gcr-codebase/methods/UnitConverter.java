import java.util.*;
public class UnitConverter {

    public static double convertKmToMiles(double kilometers){
        return kilometers*0.621371;
    }

    public static double convertMilesToKilometers(double distanceMiles){
        return distanceMiles*1.60934;
    }

    public static double convertMetersToFeet(double meters){
        return meters*3.28084;
    }

    public static double convertFeetToMeters(double distanceFeets){
        return distanceFeets*0.3048;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the distance in km: ");
        double kilometers = sc.nextDouble();
        double miles = convertKmToMiles(kilometers);
        System.out.println(kilometers + " kilometers = " + miles + " miles");

        System.out.println("Enter distance in miles: ");
        double distanceMiles = sc.nextDouble();
        double km = convertMilesToKilometers(distanceMiles);
        System.out.println(distanceMiles + " miles = " + km + " kilometers");

        System.out.println("Enter distance in meters: ");
        double meters = sc.nextDouble();
        double feets = convertMetersToFeet(meters);
        System.out.println(meters + " meters = " + feets + " feets");

        System.out.println("Enter distance in feets: ");
        double distanceFeets = sc.nextDouble();
        double m = convertFeetToMeters(distanceFeets);
        System.out.println(distanceFeets + " feets = " + m + " meters");

        sc.close();
    }
}
