import java.util.*;
public class QuadraticRoots {

    public static double[] roots(double a, double b, double c){
        double delta = Math.pow(b, 2) + 4 * a * c;
        if(delta > 0){
            double root1 = (-b + Math.sqrt(delta)) / (2*a);
            double root2 = (-b - Math.sqrt(delta)) / (2*a);

            return new double[]{root1, root2};
        }
        else if(delta == 0){
            double root = -b / (2*a);
            return new double[]{root};
        }
        else{
            return new double[]{}; 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of a, b, c: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        double[] answer = roots(a,b,c);
        if(answer.length == 0) System.out.println("No real roots");
        else for(double r : answer) System.out.println("Roots: " + r);

        sc.close();
    }
}
