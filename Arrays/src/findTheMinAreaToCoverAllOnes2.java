public class findTheMinAreaToCoverAllOnes2 {

    //  3197. Find the Minimum Area to Cover All Ones II

    //  Method 1 : Enhanced version of Method 2

    public static int minimumSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minArea = rows * cols * 3;

        // Horizontal splits
        for (int firstRow = 0; firstRow < rows - 1; firstRow++) {
            for (int secondRow = firstRow + 1; secondRow < rows - 1; secondRow++) {
                int area1 = computeArea(grid,0, 0, firstRow, cols - 1);
                int area2 = computeArea(grid,firstRow + 1, 0, secondRow, cols - 1);
                int area3 = computeArea(grid,secondRow + 1, 0, rows - 1, cols - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        // Vertical splits
        for (int firstCol = 0; firstCol < cols - 1; firstCol++) {
            for (int secondCol = firstCol + 1; secondCol < cols - 1; secondCol++) {
                int area1 = computeArea(grid,0, 0, rows - 1, firstCol);
                int area2 = computeArea(grid,0, firstCol + 1, rows - 1, secondCol);
                int area3 = computeArea(grid,0, secondCol + 1, rows - 1, cols - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        // Hybrid splits - Case 1
        for (int row = 0; row < rows - 1; row++) {
            int area1 = computeArea(grid,0, 0, row, cols - 1);
            for (int col = 0; col < cols - 1; col++) {
                int area2 = computeArea(grid,row + 1, 0, rows - 1, col);
                int area3 = computeArea(grid,row + 1, col + 1, rows - 1, cols - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        // Hybrid splits - Case 2
        for (int row = rows - 2; row >= 0; row--) {
            int area1 = computeArea(grid,row + 1, 0, rows - 1, cols - 1);
            for (int col = 0; col < cols - 1; col++) {
                int area2 = computeArea(grid,0, 0, row, col);
                int area3 = computeArea(grid,0, col + 1, row, cols - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        // Hybrid splits - Case 3
        for (int col = 0; col < cols - 1; col++) {
            int area1 = computeArea(grid,0, 0, rows - 1, col);
            for (int row = 0; row < rows - 1; row++) {
                int area2 = computeArea(grid,0, col + 1, row, cols - 1);
                int area3 = computeArea(grid,row + 1, col + 1, rows - 1, cols - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        // Hybrid splits - Case 4
        for (int col = cols - 2; col >= 0; col--) {
            int area1 = computeArea(grid,0, col + 1, rows - 1, cols - 1);
            for (int row = 0; row < rows - 1; row++) {
                int area2 = computeArea(grid,0, 0, row, col);
                int area3 = computeArea(grid,row + 1, 0, rows - 1, col);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        return minArea;
    }

    private static int computeArea(int[][] grid,int r1, int c1, int r2, int c2) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (minR == Integer.MAX_VALUE) {
            return 0;
        }
        return (maxR - minR + 1) * (maxC - minC + 1);
    }


    //  Method 2 : --------------------------------------------------------------------------------------------

    public static int minimumSum2(int[][] grid) {
        int[][] rotated = rotate90(grid);
        return Math.min(solve(grid), solve(rotated));
    }

    public static int boundingBoxArea(int[][] grid, int u, int d, int l, int r){
        int minRow = grid.length, maxRow = -1;
        int minCol = grid[0].length, maxCol = -1;

        for(int i=u;i<=d;i++){
            for(int j=l;j<=r; j++){
                if(grid[i][j] == 1){
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        if(maxRow == -1){
            return Integer.MAX_VALUE/3;
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public static int solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int best = n * m;

        //Case 1: L- shaped partitions
        for (int row = 0; row + 1 < n; row++) {
            for (int col = 0; col + 1 < m; col++) {
                //Top + Bottom - left + Bottom - right
                int area1 = boundingBoxArea(grid, 0, row, 0, m - 1)
                        + boundingBoxArea(grid, row + 1, n - 1, 0, col)
                        + boundingBoxArea(grid, row + 1, n - 1, col + 1, m - 1);

                //top-left + top-right + bottom
                int area2 = boundingBoxArea(grid, 0, row, 0, col)
                        + boundingBoxArea(grid, 0, row, col + 1, m - 1)
                        + boundingBoxArea(grid, row + 1, n - 1, 0, m - 1);

                best = Math.min(best, Math.min(area1, area2));
            }
        }

        //Case 2 : Three horizontal strips

        for (int r1 = 0; r1 + 2 < n; r1++) {
            for (int r2 = r1 + 1; r2 + 1 < n; r2++) {
                int area = boundingBoxArea(grid, 0, r1, 0, m - 1)
                        + boundingBoxArea(grid, r1 + 1, r2, 0, m - 1)
                        + boundingBoxArea(grid, r2 + 1, n - 1, 0, m - 1);
                best = Math.min(best, area);
            }
        }
        return best;
    }

    public static int[][] rotate90(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] rotated = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = grid[i][j];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(new int[][]{{1,0,1},{1,1,1}}));
        System.out.println(minimumSum(new int[][]{{1,0,1,0},{0,1,0,1}}));
        System.out.println(
                minimumSum(new int[][]{
                        {1, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0},
                        {0, 0, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}, {0, 1, 0, 0},
                        {1, 1, 0, 1}, {0, 0, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1},
                        {0, 1, 1, 1}, {0, 1, 1, 0}
                })
        );
        System.out.println(minimumSum(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}}));

    }
}
