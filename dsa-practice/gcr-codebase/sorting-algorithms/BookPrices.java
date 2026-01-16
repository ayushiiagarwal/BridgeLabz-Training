// Merge Sort

import java.util.Arrays;

public class BookPrices {

    public static void sort(int[] prices, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;

            sort(prices, left, mid);
            sort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(int[] prices, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(prices, left, leftArray, 0, n1);
        System.arraycopy(prices, mid+1, rightArray, 0, n2);

        int i=0, j=0, k=left;
        while(i<n1 && j<n2){
            if(leftArray[i] <= rightArray[j])
                prices[k++] = leftArray[i++];
            else
                prices[k++] = rightArray[j++];
        }
        while(i<n1) prices[k++] = leftArray[i++];
        while(j<n2) prices[k++] = rightArray[j++];
    }
    public static void main(String[] args) {
        int[] prices = {500, 450, 350, 1000, 480};

        System.out.println("Initial Array: " + Arrays.toString(prices));
        sort(prices, 0, prices.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(prices));
    }
}
