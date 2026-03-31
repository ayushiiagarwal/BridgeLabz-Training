import java.util.Scanner;

public class BMI2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = sc.nextInt();

        double[][] data = new double[num][3]; // weight, height, BMI
        String[] status = new String[num];

        System.out.println("Enter weight (kg) and height (m): ");
        for (int i = 0; i < num; i++) {
            double weight = sc.nextDouble();
            double height = sc.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            double bmi = weight / (height * height);
            data[i][0] = weight;
            data[i][1] = height;
            data[i][2] = bmi;

            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 25) status[i] = "Normal";
            else if (bmi < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < num; i++) {
            System.out.printf("Person %d: Height = %.2f m, Weight = %.2f kg, BMI = %.2f, Status = %s%num",
                    (i + 1), data[i][1], data[i][0], data[i][2], status[i]);
        }

        sc.close();
    }
}
