import java.util.*;

class Exam {

    Stack<Integer> questions = new Stack<>();
    HashMap<Integer, String> answers = new HashMap<>();

    void visitQuestion(int questionId) {
        questions.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    void answerQuestion(int questionId, String answer) {
        answers.put(questionId, answer);
        System.out.println("Answered Question " + questionId + ": " + answer);
        System.out.println();
    }

    int evaluateScore() {
        int score = 0;

        HashMap<Integer, String> correctAnswers = new HashMap<>();
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");

        for (int quesID : answers.keySet()) {
            if (answers.get(quesID).equals(correctAnswers.get(quesID))) {
                score++;
            }
        }
        return score;
    }
}

public class ExamProctor {
    public static void main(String[] args) {

        Exam exam = new Exam();

        exam.visitQuestion(1);
        exam.answerQuestion(1, "A");

        exam.visitQuestion(2);
        exam.answerQuestion(2, "B");

        exam.visitQuestion(3);
        exam.answerQuestion(3, "B");

        int finalScore = exam.evaluateScore();
        System.out.println("Final Score: " + finalScore);
    }
}
