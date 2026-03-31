// Count Sort

import java.util.Arrays;

public class StudentAges {

    public static void countSort(int[] ages){
        int n = ages.length;

        int max = ages[0];
        for(int i=0;i<n;i++){
            if(ages[i] > max)
                max = ages[i];
        }

        int[] count = new int[max + 1];
        for(int i=0;i<n;i++){
            count[ages[i]]++;
        }

        int index = 0;
        for(int i=0;i<=max;i++){
            while(count[i] > 0){
                ages[index] = i;
                index++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] ages = {15, 12, 12, 13, 17, 20, 17};

        System.out.println("Unsorted Array: " + Arrays.toString(ages));
        countSort(ages);
        System.out.println("Sorted Array: " + Arrays.toString(ages));
    }
}
