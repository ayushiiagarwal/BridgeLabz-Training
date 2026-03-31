import java.util.Scanner;
public class EduQuiz {

    public static int calculateScore(char[] correct, char[] student){
        int score = 0;
        for(int i=0;i<correct.length;i++){
            if(correct[i] == Character.toLowerCase(student[i])){
                score++;
                System.out.println("Question " + (i+1) + ": Correct");
            }
            else
                System.out.println("Question " + (i+1) + ": Incorrect");
        }
        return score;
    }

    public static void displayResult(int score){
        double percentage = ((double) score / 10) * 100;

        System.out.println("Final Score: " + score + "/" + 10);
        System.out.println("Percentage: " + percentage + " %");
    }

    public static void main(String[] args) {
        char[] correctAnswers = {'a', 'c', 'b', 'a', 'd', 'b', 'd', 'c', 'b', 'a'};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter answers: ");
        char[] studentAnswers = new char[10];
        for(int i=0;i<10;i++){
            studentAnswers[i] = sc.next().charAt(0);
        }

        System.out.println("Score: " + calculateScore(correctAnswers, studentAnswers));

        displayResult(calculateScore(correctAnswers, studentAnswers));

        sc.close();
    }
}
