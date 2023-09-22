package algorithms.arrays;

public class TransposeMatrix {

    public static void main(String []args){
        int[][] matrix = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 }
        };

        int[][] matrix_2 = {
                { 1, 2 }
        };

        int result[][] = transposeMatrix(matrix_2);

        int n = result.length, m = result[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    private static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                result[j][i] = matrix[i][j];
        return result;
    }
}


