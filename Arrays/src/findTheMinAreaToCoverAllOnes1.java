public class findTheMinAreaToCoverAllOnes1 {

    //  3195. Find the Minimum Area to Cover All Ones I

    public static int minimumSum(int[][] grid) {
        int minRow = grid.length , maxRow = 0;
        int minCol = grid[0].length , maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    minRow = Math.min(minRow,i);
                    maxRow = Math.max(maxRow,i);
                    minCol = Math.min(minCol,j);
                    maxCol = Math.max(maxCol,j);
                }
            }
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(new int[][]{{1,0,1},{1,1,1}}));
        System.out.println(minimumSum(new int[][]{{1,0,1,0},{0,1,0,1}}));
        System.out.println(minimumSum(new int[][]{{1, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 0},
                {1, 0, 0, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 0},
                {0, 1, 0, 0}, {1, 1, 0, 1}, {0, 0, 1, 1}, {1, 0, 0, 0},
                {1, 1, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(minimumSum(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}}));
    }
}
