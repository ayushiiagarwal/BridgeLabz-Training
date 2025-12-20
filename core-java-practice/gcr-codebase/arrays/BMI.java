

import java.util.*;
public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        System.out.println("Enter weight (in kg) and height (in meters): ");
        for (int i = 0; i < number; i++) {
            weight[i] = sc.nextDouble();
            height[i] = sc.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) 
                status[i] = "Underweight";
            else if (bmi[i] < 25) 
                status[i] = "Normal";
            else if (bmi[i] < 30) 
                status[i] = "Overweight";
            else 
                status[i] = "Obese";
        }

        for (int i = 0; i < number; i++) {
            System.out.println(height[i]);
            System.out.println(weight[i]);
            System.out.println(bmi[i]);
            System.out.println(status[i]);
        }

        sc.close();
    }
}
