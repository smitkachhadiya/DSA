import java.util.Arrays;

public class largestSubmatrixWithRearrangement {

    //  1727. Largest Submatrix With Rearrangements

    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;

        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i - 1][j];

        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < n; j++)
                res = Math.max(res, matrix[i][j] * (n - j));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1}}));
        System.out.println(largestSubmatrix(new int[][]{{1,0,1,0,1}}));
    }
}
