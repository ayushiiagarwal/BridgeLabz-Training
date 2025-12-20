import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] math = new int[n];
        double[] percentage = new double[n];
        char[] grades = new char[n];

        System.out.println("Enter marks for Physics, Chemistry and Maths: ");
        for (int i = 0; i < n; ) {
            physics[i] = sc.nextInt();
            chemistry[i] = sc.nextInt();
            math[i] = sc.nextInt();

            if (physics[i] < 0 || chemistry[i] < 0 || math[i] < 0) {
                System.out.println("Marks can't be negative.");
                continue;
            }

            percentage[i] = (physics[i] + chemistry[i] + math[i]) / 3.0;

            if (percentage[i] >= 90) grades[i] = 'A';
            else if (percentage[i] >= 80) grades[i] = 'B';
            else if (percentage[i] >= 70) grades[i] = 'C';
            else if (percentage[i] >= 60) grades[i] = 'D';
            else grades[i] = 'F';
            i++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": " + "Physics = " + physics[i] +
                    ", Chemistry = " + chemistry[i] + ", Maths = " + math[i] +
                    ", Percentage = " + percentage[i] + "%, Grade = " + grades[i]);
        }

        sc.close();
    }
}
