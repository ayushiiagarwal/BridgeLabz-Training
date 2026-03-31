import java.util.*;
public class YardsToFeets {

    public static double convertYardsToFeets(double yards){
        return yards*3;
    }

    public static double convertFeetsToYards(double distanceFeet){
        return distanceFeet*0.333333;
    }

    public static double convertMetersToInches(double meters){
        return meters*39.3701;
    }

    public static double convertInchesToMeters(double distanceInches){
        return distanceInches*0.0254;
    }

    public static double convertInchesToCentimeters(double distanceInches){
        return distanceInches*2.54;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the distance in yards: ");
        double yards = sc.nextDouble();
        double feet = convertYardsToFeets(yards);
        System.out.println(yards + " yards = " + feet + " feet");

        System.out.println("Enter distance in feets: ");
        double distanceFeet = sc.nextDouble();
        double y = convertFeetsToYards(distanceFeet);
        System.out.println(distanceFeet + " miles = " + y + " yards");

        System.out.println("Enter distance in meters: ");
        double meters = sc.nextDouble();
        double inches = convertMetersToInches(meters);
        System.out.println(meters + " meters = " + inches + " inches");

        System.out.println("Enter distance in inches: ");
        double distanceInches = sc.nextDouble();
        double m = convertInchesToMeters(distanceInches);
        System.out.println(distanceInches + " feets = " + m + " meters");

        double cm = convertInchesToCentimeters(distanceInches);
        System.out.println(distanceInches + " inches = " + cm + " cm");


        sc.close();
    }
}
