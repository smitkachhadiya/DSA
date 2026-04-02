public class matrixSimilarityAfterCyclicShifts {

    //  2946. Matrix Similarity After Cyclic Shifts

    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k %= n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (mat[i][j] != mat[i][(j + k) % n]) {
                        return false;
                    }
                } else {
                    if (mat[i][j] != mat[i][(j - k + n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areSimilar(new int[][]{{1,2,3},{4,5,6},{7,8,9}},4));
    }
}
