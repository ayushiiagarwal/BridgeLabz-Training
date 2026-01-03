import java.util.Scanner;
public class TemperatureAnalyzer {
    
    public static float[] calculateDailyAverages(float[][] temp) {
        float[] averages = new float[temp.length];
        for (int i = 0; i < temp.length; i++) {
            float sum = 0;
            for (float j : temp[i]) {
                sum += j;
            }
            averages[i] = sum / temp[i].length;
        }
        return averages;
    }

    public static int[] findExtremeDays(float[][] data) {
        float maxTemp = Float.NEGATIVE_INFINITY;
        float minTemp = Float.POSITIVE_INFINITY;
        int hotDay = 0;
        int coldDay = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                float current = data[i][j];
                if (current > maxTemp) {
                    maxTemp = current;
                    hotDay = i;
                }
                if (current < minTemp) {
                    minTemp = current;
                    coldDay = i;
                }
            }
        }
        return new int[]{hotDay, coldDay};
    }

    public static void displayResults(String[] dayNames, float[] averages, int[] extremes) {        
        System.out.println("\n--- Analysis Results ---");
        for (int i = 0; i < dayNames.length; i++) {
            System.out.printf("%s Average: %.2f°\n", dayNames[i], averages[i]);
        }

        System.out.println("\nHottest Day: " + dayNames[extremes[0]]);
        System.out.println("Coldest Day: " + dayNames[extremes[1]]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float[][] temperatures = new float[7][24];
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println("--- Weekly Temperature Data Entry ---");

        for (int i = 0; i < 7; i++) {
            System.out.println("Enter 24 temperatures for " + days[i] + ":");
            for (int j = 0; j < 24; j++) {
                temperatures[i][j] = sc.nextFloat();
            }
        }

        float[] averages = calculateDailyAverages(temperatures);
        int[] extremes = findExtremeDays(temperatures);

        displayResults(days, averages, extremes);

        sc.close();
    }
}