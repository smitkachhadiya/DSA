public class gridGame {

    // 2017. Grid Game

    public static long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] topPrefix = new long[n + 1];
        long[] bottomPrefix = new long[n + 1];

        for(int i=0 ; i < n ; i++){
            topPrefix[i+1] = topPrefix[i] + grid[0][i];
            bottomPrefix[i+1] = bottomPrefix[i] + grid[1][i];
        }

        long ans = Long.MAX_VALUE;

        for(int i=0 ; i < n ; i++){
            long pointsTop = topPrefix[n] - topPrefix[i+1];
            long pointsBottom = bottomPrefix[i];

            long secondRobotPoints = Math.max(pointsTop, pointsBottom);
            ans = Math.min(ans, secondRobotPoints);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1,3,1,15},
                {1,3,3,1}
        };
        System.out.println(gridGame(arr));
    }
}
