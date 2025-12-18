// Program to compute the volume of Earth in km^3 and miles^3
import java.util.*;
public class VolumeOfEarth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the Earth in kilometers:");
        double radiusKm = sc.nextDouble(); // Radius of Earth in kilometers

        double volumeKm = (4.0 / 3.0) * 3.14 * (radiusKm * radiusKm * radiusKm);

        double radiusMiles = radiusKm * 0.621371; // Convert radius to miles
        double volumeMiles = (4.0 / 3.0) * 3.14 * (radiusMiles * radiusMiles * radiusMiles);
        System.out.println("Volume of Earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);

        sc.close();
    }
}
