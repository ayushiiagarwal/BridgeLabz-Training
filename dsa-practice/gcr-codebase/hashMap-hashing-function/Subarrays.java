import java.util.HashMap;

public class Subarrays {

    public static void findSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                System.out.println("Subarray from index 0 to " + i);
            }

            if (map.containsKey(sum)) {
                System.out.println("Subarray ending at index " + i);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, -4};

        findSum(arr);
    }
}
