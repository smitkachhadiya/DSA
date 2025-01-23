public class countServerThatCommunicate {

    //  1267. Count Servers that Communicate

    public static int countServers(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[] rowComputer = new int[m];
        int[] columnComputer = new int[n];

        for(int i=0 ; i < m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1){
                    rowComputer[i]++;
                    columnComputer[j]++;
                }
            }
        }

        for(int i=0 ; i < m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == 1 && (rowComputer[i] > 1 || columnComputer[j] > 1)){
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String args[]){
        int[][] grid = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 0}};
        System.out.println(countServers(grid));
    }
}
