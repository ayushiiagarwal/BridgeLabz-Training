// Both Linear and Binary Search

import java.util.Arrays;

public class ChallengeProblem {
    public static void main(String[] args) {

        int[] arr = {2, 4, -1, 1};
        int target = 4;
        int n = arr.length;

        boolean[] visited = new boolean[n + 1];

        for (int i=0; i<n; i++) {
            if(arr[i] > 0 && arr[i] <= n){
                visited[arr[i]] = true;
            }
        }

        int missingPositive = -1;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                missingPositive = i;
                break;
            }
        }

        if(missingPositive == -1)
            missingPositive = n + 1;

        System.out.println("First Missing Positive Integer: " + missingPositive);

        Arrays.sort(arr);

        int left = 0, right = n - 1, index = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == target){
                index = mid;
                break;
            }
            else if(arr[mid] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }

        System.out.println("Index of target " + target + ": " + index);
    }
}
