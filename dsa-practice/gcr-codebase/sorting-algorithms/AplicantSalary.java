// Heap Sort
import java.util.Arrays;

public class AplicantSalary {

    public static void heapSort(int[] salaries) {

        int n = salaries.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }

    public static void heapify(int[] salaries, int heapSize, int root) {
        int largest = root;            
        int left = 2 * root + 1;       
        int right = 2 * root + 2;      

        if (left < heapSize && salaries[left] > salaries[largest]) 
            largest = left;

        if (right < heapSize && salaries[right] > salaries[largest]) 
            largest = right;

        if (largest != root) {
            int temp = salaries[root];
            salaries[root] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {45000, 50000, 90000, 30000, 20000};

        System.out.println("Unsorted Array: " + Arrays.toString(salaries));
        heapSort(salaries);
        System.out.println("Sorted Array: " + Arrays.toString(salaries));
    }
}
