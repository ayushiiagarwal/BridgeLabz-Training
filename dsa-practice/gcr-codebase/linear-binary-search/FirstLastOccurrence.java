// Binary Search - Find First and Last Occurence of a an Element in a Sorted Array

public class FirstLastOccurrence {
    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 6, 7, 8};
        int target = 4;

        int n = arr.length;

        int first = -1, last = -1;

        int left = 0, right = n - 1;

        while(left<right) {
            int mid = (left+right) / 2;

            if(arr[mid] == target){
                first = mid;        
                right = mid - 1;    
            }
            else if(arr[mid]<target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        left = 0;
        right = n - 1;

        while(left<right){

            int mid = (left+right) / 2;

            if(arr[mid] == target){
                last = mid;         
                left = mid + 1;     
            }
            else if (arr[mid]<target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        if(first == -1){
            System.out.println("First Occurrence: -1");
            System.out.println("Last Occurrence: -1");
        } else {
            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);
        }
    }
}
