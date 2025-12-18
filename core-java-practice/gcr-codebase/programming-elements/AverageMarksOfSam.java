// Find the average percent mark in PCM.

public class AverageMarksOfSam {
    public static void main(String[] args) {
        int chemistryMarks = 94;
        int mathematicsMarks = 96;
        int physicsMarks = 95;
        int totalMarks = physicsMarks + chemistryMarks + mathematicsMarks;
        
        double averagePercent = (totalMarks / 300.0) * 100;

        System.out.println("Sam's average percent mark in PCM is: " + averagePercent + "%");    
    }   
}
