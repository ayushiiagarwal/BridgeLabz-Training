import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Weight and Height: ");
        double weight = sc.nextDouble();
        double height = sc.nextDouble();

        height /= 100;
        double bmi = weight / (height * height);
        if (bmi <= 18.4)
            System.out.println("Underweight");
        else if (bmi <= 24.9)
            System.out.println("Normal");
        else if (bmi <= 39.9)
            System.out.println("Overweight");
        else
            System.out.println("Obese");

        sc.close();
    }
}
