import java.util.*;
public class BusRouteDistanceTracker{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double totalDistance = 0.0;

        while (true){
            System.out.println("Enter the distance to the next stop:");
            double distance = sc.nextDouble();

            totalDistance += distance;

            System.out.println("Total distance traveled so far: " + totalDistance);

            System.out.println("Do you want to get off at this stop? (yes/no)");
            String response = sc.next();

            if (response.equalsIgnoreCase("yes")){
                System.out.println("Total distance traveled: " + totalDistance);
                break;
            }
        }        
        
        sc.close();
    }
}