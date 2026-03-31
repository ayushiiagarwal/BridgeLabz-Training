// Binary Search - Find the PEak Element (Element greater than its both neighbours)

public class PeakElement {
    public static void main(String[] args) {
        int[] array = {1, 3, 20, 5, 3, 0, 1};

        int n = array.length;

        int left = 0, right = n-1;

        while(left < right){
            int mid = (left + right) / 2;
            if(array[mid] < array[mid+1])
                left = mid + 1;
            else right = mid;
        }
        System.out.println(array[left]);
    }
}
