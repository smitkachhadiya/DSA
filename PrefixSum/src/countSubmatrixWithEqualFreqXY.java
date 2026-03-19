public class countSubmatrixWithEqualFreqXY {

    //  3212. Count Submatrices With Equal Frequency of X and Y

    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] colX = new int[n];
        int[] colY = new int[n];
        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'X') colX[j]++;
                if(grid[i][j] == 'Y') colY[j]++;
            }

            int x = 0, y = 0;
            for(int j = 0; j < n; j++) {
                x += colX[j];
                y += colY[j];
                if(x == y && x > 0) ans++;
            }
        }
        return ans;
    }

    //  Method 2

    public static int numberOfSubmatrices2(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        int[][] px = new int[m][n];
        int[][] py = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                px[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                py[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                if (i > 0) {
                    px[i][j] += px[i - 1][j];
                    py[i][j] += py[i - 1][j];
                }
                if (j > 0) {
                    px[i][j] += px[i][j - 1];
                    py[i][j] += py[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    px[i][j] -= px[i - 1][j - 1];
                    py[i][j] -= py[i - 1][j - 1];
                }

                if (px[i][j] == py[i][j] && px[i][j] > 0) {
                    ans++;
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        System.out.println(numberOfSubmatrices(new char[][]{{'x','y','.'},{'y','.','.'}}));
        System.out.println(numberOfSubmatrices(new char[][]{{'x','x'},{'x','y'}}));
    }
}
