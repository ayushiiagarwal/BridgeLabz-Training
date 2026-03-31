// Quick Sort

import java.util.Arrays;

public class ProductPrices {

    public static void quickSort(int[] prices, int low, int high){
        if(low < high){
            int p = partition(prices, low, high);
            quickSort(prices, low, p-1);
            quickSort(prices, p+1, high);
        }
    }

    private static int partition(int[] prices, int low, int high){
        int pivot = prices[high];
        int i= low - 1;
        for(int j=low; j<high; j++){
            if(prices[j] < pivot){
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[i+1];
        prices[i+1] = prices[high];
        prices[high] = temp;
        return i+1;
    }
    public static void main(String[] args) {
        int[] prices = {250, 300, 620, 400, 350};

        System.out.println("Initial Array: " + Arrays.toString(prices));
        quickSort(prices, 0, prices.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(prices));
    }
}
