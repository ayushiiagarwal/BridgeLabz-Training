// Binary Search - Find the Rotation Point in a Rotated Sorted Array

import java.util.*;
public class FindRotationPoint {

    public static int rotationPoint(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(array[mid] > array[right])
                left = mid + 1;
            else right = mid;
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sorted array of 5 elements: ");
        int[] array = new int[5];

        for(int i=0;i<5;i++){
            array[i] = sc.nextInt();
        }

        sc.close();

        int result = rotationPoint(array);
        System.out.println("Index of the smallest element: " + result);
    }
}
