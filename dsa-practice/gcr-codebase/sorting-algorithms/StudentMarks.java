// Bubble Sort
import java.util.Arrays;

public class StudentMarks{
    
    public static void sortMarks(int[] marks){
        int n = marks.length;

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(marks[j] > marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] marks = {90, 85, 78, 60, 30};

        System.out.println("Initial Marks: " + Arrays.toString(marks));
        sortMarks(marks);
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
    }
}