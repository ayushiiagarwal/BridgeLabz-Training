// Find the average percent mark in PCM.

public class AvereageMarksOfSam {
    public static void main(String[] args) {
        int physicsMarks = 95;
        int chemistryMarks = 94;
        int mathematicsMarks = 96;

        int totalMarks = physicsMarks + chemistryMarks + mathematicsMarks;
        double averagePercent = (totalMarks / 300.0) * 100;

        System.out.println("Sam's average percent mark in PCM is: " + averagePercent + "%");    
    }   
}
