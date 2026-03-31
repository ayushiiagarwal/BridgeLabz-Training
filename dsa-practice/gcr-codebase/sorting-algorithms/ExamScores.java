// Selection Sort
import java.util.Arrays;

public class ExamScores {

    public static void selectionSort(int[] scores){
        int n = scores.length;

        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j = i+1; j<n;j++){
                if(scores[j] < scores[min])
                    min = j;
            }

            int temp = scores[min];
            scores[min] = scores[i];
            scores[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] scores = {90, 48, 70, 60, 80};

        System.out.println("Unsorted Array: " + Arrays.toString(scores));
        selectionSort(scores);
        System.out.println("Sorted Array: " + Arrays.toString(scores));
    }
}
