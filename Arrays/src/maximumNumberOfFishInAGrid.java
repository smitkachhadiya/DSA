public class maximumNumberOfFishInAGrid {

    // 2658. Maximum Number of Fish in a Grid

    public static int findMaxFish(int[][] grid) {
        int maxFish = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] > 0 && !visited[r][c]){
                    maxFish = Math.max(maxFish,dfs(grid,r,c,visited));
                }
            }
        }
        return maxFish;
    }

    public static int dfs(int[][] grid , int r , int c , boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]){
            return 0;
        }

        visited[r][c] = true;
        int fish = grid[r][c];

        fish += dfs(grid, r + 1, c, visited);
        fish += dfs(grid, r - 1, c, visited);
        fish += dfs(grid, r, c + 1, visited);
        fish += dfs(grid, r, c - 1, visited);

        return fish;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };

        int[][] grid2 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };

        System.out.println("Maximum fish in grid1: " + findMaxFish(grid1));
        System.out.println("Maximum fish in grid2: " + findMaxFish(grid2));
    }
}
