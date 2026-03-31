import java.util.*;
public class MatrixAdvanced {
    public static int[][] createMatrix(int rows, int columns) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = random.nextInt(10);
        return matrix;
    }

    public static int[][] getTranspose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }

    public static int getDeterminant(int[][] x) {
        return x[0][0] * x[1][1] - x[0][1] * x[1][0];
    }

    public static double[][] getInverse(int[][] x) {
        int d = getDeterminant(x);
        if (d == 0) return null;
        double[][] inverse = {
            {(double)x[1][1] / d, (double)-x[0][1] / d},
            {(double)-x[1][0] / d, (double)x[0][0] / d}
        };
        return inverse;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = createMatrix(2, 2);
        System.out.println("Original:");
        printMatrix(matrix);
        System.out.println("Transpose:");
        printMatrix(getTranspose(matrix));
        System.out.println("Determinant: " + getDeterminant(matrix));
        double[][] inverse = getInverse(matrix);
        if (inverse != null) {
            System.out.println("Inverse:");
            for (double[] row : inverse) {
                for (double i : row) System.out.print(i + " ");
                System.out.println();
            }
        } else {
            System.out.println("No getInverse (d=0)");
        }
    }
}