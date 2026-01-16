// Insertion Sort

import java.util.Arrays;

public class EmployeeID {

    public static void sort(int[] id){
        int n = id.length;

        for(int i=0;i<n;i++){
            int key = id[i];
            int j = i-1;
            while(j >= 0 && id[j] > key){
                id[j+1] = id[j];
                j--;
            }
            id[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] id = {101, 105, 102, 103, 104, 106};

        System.out.println("Initial Array: " + Arrays.toString(id));
        sort(id);

        System.out.println("Sorted Array: " + Arrays.toString(id));
    }
}
