import java.util.Scanner;
public class StudentScores {

    public static double averageMarks(int[] scores){
        double sum = 0;
        for(int i=0;i<scores.length;i++){
            sum += scores[i];
        }
        double average = sum / scores.length;
        return average;
    }

    public static void highestAndLowest(int[] scores){
        int highest = scores[0];
        for(int i=0;i<scores.length;i++){
            if(highest < scores[i])
                highest = scores[i];
        }

        int lowest = scores[0];
        for(int i=0;i<scores.length;i++){
            if(lowest > scores[i])
                lowest = scores[i];
        }

        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);

    }

    public static void scoresAboveAverage(int[] scores, double avg){
        System.out.print("Scores above than average score: ");
        for(int i=0;i<scores.length;i++){
            if(scores[i] > avg){
                System.out.print(scores[i] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();

        System.out.println("Enter the marks: ");
        int[] marks = new int[n];
        for(int i=0;i<n;i++){
            marks[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            if(marks[i] < 0)
                System.out.println("Invalid input!");
        }

        double avg = averageMarks(marks);
        System.out.println("Average Scores: " + avg);
        highestAndLowest(marks);
        scoresAboveAverage(marks, avg);

        sc.close();
    }
}
