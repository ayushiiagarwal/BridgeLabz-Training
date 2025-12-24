import java.util.*;
public class SimpleInterest{

    public static double simpleInterest(double principal, double rate, double time){
        double SI = (principal*rate*time)/100;

        return SI;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter the principal amount: ");
        double principal = sc.nextInt();

        System.out.println("Enter rate of interest (%): ");
        double rate = sc.nextInt();

        System.out.println("Enter time (in years): ");
        double time = sc.nextInt();

        double result = simpleInterest(principal, rate, time);

        System.out.println("The Simple Interest is " + result + "for principal " + principal + ", Rate of interest " + rate + " and time " + time);

        sc.close();
    }
}