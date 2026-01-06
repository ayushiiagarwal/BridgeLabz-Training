import java.util.*;

class InvalidQuizSubmissionException extends Exception{
    public InvalidQuizSubmissionException(String message){
        super(message);
    }
}

public class OnlineQuizPlatform {
    private List<Integer> scores = new ArrayList<>();

    public void result(String[] correctAnswers, String[] studentAnswers){
        try{
            if(correctAnswers.length != studentAnswers.length){
                throw new InvalidQuizSubmissionException("Mandatory to Attempt all Questions");
            }

            int mark = calculateScore(correctAnswers, studentAnswers);
            String grade = gradeScore(mark, correctAnswers.length);

            scores.add(mark);

            System.out.println("Score: " + mark + "/" + correctAnswers.length);
            System.out.println("Grade: " + grade);

        }
        catch(InvalidQuizSubmissionException e){
            System.out.println(e.getMessage());
        }
    }

    public int calculateScore(String[] correctAnswers, String[] studentAnswers){
        int correctCount = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public String gradeScore(int mark, int total){
        double percentage = ((double) mark / total) * 100;

        if (percentage >= 90) return "A";
        if (percentage >= 75) return "B";
        if (percentage >= 50) return "C";
        return "F";
    }


    public static void main(String[] args) {
        OnlineQuizPlatform quiz = new OnlineQuizPlatform();

        String[] answers = {"A", "B", "C", "D"};

        System.out.println("Student 1: ");
        String[] student1 = {"A", "B", "X", "D"}; 
        quiz.result(answers, student1);

        System.out.println("\nStudent 2: ");
        String[] student2 = {"A", "B"}; 
        quiz.result(answers, student2);
    }
}
