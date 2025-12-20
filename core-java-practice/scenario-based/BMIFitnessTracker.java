import java.util.*;
public class BMIFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Weight (in kg): ");
        double weight = sc.nextDouble();

        System.out.println("Enter height (in cm): ");
        double height = sc.nextDouble();

        height /= 100;
        double bmi = weight / (height * height);
        if (bmi <= 18.4){
            System.out.println("Your BMI: " + bmi);
            System.out.println("You come under the Underweight category");
        }
        else if (bmi <= 24.9){
            System.out.println("Your BMI: " + bmi);
            System.out.println("You come under the Normal category");
        }
        else if (bmi <= 39.9){
            System.out.println("Your BMI: " + bmi);
            System.out.println("You come under the Overweight category");
        }
        else{
            System.out.println("Your BMI: " + bmi);
            System.out.println("You come under the Obese category");
        }
        sc.close();
    }
}
