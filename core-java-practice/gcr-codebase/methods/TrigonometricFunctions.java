import java.util.*;
public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double rad = Math.toRadians(angle);
        return new double[]{Math.sin(rad), Math.cos(rad), Math.tan(rad)};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the angle: ");
        double angle = sc.nextDouble();
        
        double[] result = calculateTrigonometricFunctions(angle);
        for (double i : result) System.out.println(i);

        sc.close();
    }
}