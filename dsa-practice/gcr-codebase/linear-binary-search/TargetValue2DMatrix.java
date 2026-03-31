// Binary Search - Search for a Target Value in a 2D Sorted Array

public class TargetValue2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                        {10, 15, 18, 19},
                        {21, 25, 29, 30}
                    };
        
        int target = 18;

        int rows = matrix.length, cols = matrix[0].length;

        int left = 0, right = rows*cols - 1;

        boolean found = false;

        while(left < right){
            int mid = (left + right) / 2;

            int row = mid / cols, col = mid % cols;

            int midValue = matrix[row][col];

            if(midValue == target){
                found = true;
                break;
            }
            else if(target < midValue)
                right = mid - 1;

            else
                left = mid + 1;
        }

        if(found)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
