import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int number = sc.nextInt();

        int[][] marks = new int[number][3];
        double[] percentage = new double[number];
        char[] grade = new char[number];

        System.out.println("Enter marks for Physics, Chemistry and Maths: ");
        for (int i = 0; i < number; ) {
            marks[i][0] = sc.nextInt();
            marks[i][1] = sc.nextInt();
            marks[i][2] = sc.nextInt();

            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Marks can't be negative.");
                continue;
            }

            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 80) grade[i] = 'B';
            else if (percentage[i] >= 70) grade[i] = 'C';
            else if (percentage[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';

            i++;
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ": Physics = " + marks[i][0] +
                    ", Chemistry = " + marks[i][1] + ", Maths = " + marks[i][2] +
                    ", Percentage = " + percentage[i] + "%, Grade = " + grade[i]);
        }

        sc.close();
    }
}
