class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class StudentScoreAnalyzer {
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static void analyze(int[] scores) {
        try {
            for (int score : scores) {
                if (score < 0 || score > 100) {
                    throw new InvalidScoreException("Invalid score. Marks must be 0-100.");
                }
            }

            System.out.println("--- Score Analysis ---");
            System.out.println("Highest Score : " + findMax(scores));
            System.out.println("Lowest Score  : " + findMin(scores));
            System.out.printf("Average Score : %.2f\n", calculateAverage(scores));

        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] studentScores = {85, 92, 76, 64, 100};
        analyze(studentScores);

        System.out.println("Testing for Invalid Scores");
        int[] test = {95, -5, 88}; 
        analyze(test);
    }
}
