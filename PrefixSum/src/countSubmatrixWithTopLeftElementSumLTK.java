public class countSubmatrixWithTopLeftElementSumLTK {

    //  3070. Count Submatrices with Top-Left Element and Sum Less Than k

    public static int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] cols = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int rows = 0;
            for (int j = 0; j < m; j++) {
                cols[j] += grid[i][j];
                rows += cols[j];
                if (rows <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int countSubmatrices2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+1][j+1] = grid[i][j] + sum[i][j+1] + sum[i+1][j] - sum[i][j];
                if (sum[i+1][j+1] <= k)
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubmatrices(new int[][]{{7,6,3},{6,6,1}},18));
        System.out.println(countSubmatrices(new int[][]{{7,2,9},{1,5,0},{2,6,6}},18));
        System.out.println(countSubmatrices(new int[][]{{7,2,9},{1,5,0},{2,6,6}},20));
    }
}
