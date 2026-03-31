import java.util.*;
public class LineComparisonProblem {

    public static double useCase1(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    public static void useCase2(Double length1, Double length2){
        if(length1.equals(length2))
            System.out.println("Line 1 is equal to Line 2");
        else
            System.out.println("Line 1 is not equal to Line 2");
    }

    public static void useCase3(Double length1, Double length2){
        int comparison = length1.compareTo(length2);

        if(comparison > 0)
            System.out.println("Line 1 is greater than Line 2.");
        else if(comparison < 0)
            System.out.println("Line 1 is less than Line 2");
        else
            System.out.println("Lines are equal.");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Problem");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates for line 1 (x1, y1, x2, y2): ");
        double length1 = useCase1(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Length of line 1: " + length1);

        System.out.println("Enter coordinates for line 2 (x3, y3, x4, y4): ");
        double length2 = useCase1(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Length of Line 2: " + length2);

        useCase2(length1, length2);
        useCase3(length1, length2);

        sc.close();
    }
}
