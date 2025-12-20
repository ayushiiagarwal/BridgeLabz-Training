import java.util.Scanner;

public class MatrixTo1DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        
        System.out.println("Enter the number of coulumns: ");
        int columns = sc.nextInt();
        
        System.out.println("Enter the elements for a matrix: ");
        int[][] matrix = new int[rows][columns];
        int[] array = new int[rows * columns];
        int idx = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
                array[idx++] = matrix[i][j];
            }
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
