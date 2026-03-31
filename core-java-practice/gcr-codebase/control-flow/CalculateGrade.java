import java.util.Scanner;

public class CalculateGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Physics Marks: ");
        int physics = sc.nextInt();

        System.out.println("Enter CHemistry Marks: ");
        int chemistry = sc.nextInt();

        System.out.println("Enter Maths Marks: ");
        int maths = sc.nextInt();

        int total = physics + chemistry + maths;

        double percent = total / 3.0;

        System.out.println("Average Marks: " + percent);
        if (percent >= 80)
            System.out.println("Grade: A \nRemarks: Level 4, above agency-normalized standards");
        
        else if (percent >= 70)
            System.out.println("Grade: B \nRemarks: Level 3, at agency-normalized standards");

        else if (percent >= 60)
            System.out.println("Grade: C \nRemarks: Level 2, below, but approaching agency-normalized standards");

        else if (percent >= 50)
            System.out.println("Grade: D \nRemarks: Level 1, well below agency-normalized standards");

        else if (percent >= 40)
            System.out.println("Grade: E \nRemarks: Level 1-, too below agency-normalized standards");

        else
            System.out.println("Grade: R \nRemarks: Remedial S");

        sc.close();
    }
}
