import java.util.Arrays;

public class minAbsDiffInSlidingSubmatrix {

    //  3567. Minimum Absolute Difference in Sliding Submatrix

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] answ = new int[m - k + 1][n - k + 1];

        for(int row = 0; row < m - k + 1;row++){
            for(int col = 0; col < n - k + 1;col++){
                int[] arr = new int[k * k];
                int index = 0;
                for(int i = row;i < row + k;i++){
                    for(int j = col;j < col + k;j++){
                        arr[index] = grid[i][j];
                        index++;
                    }
                }
                answ[row][col] = getMin(arr);
            }
        }
        return answ;
    }

    public int getMin(int[] arr){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for(int i = 1;i< arr.length;i++){
            if(arr[i - 1] != arr[i]){
                min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        minAbsDiffInSlidingSubmatrix md = new minAbsDiffInSlidingSubmatrix();
        System.out.println(md.minAbsDiff(new int[][]{{1,8},{3,-2}},2));
        System.out.println(md.minAbsDiff(new int[][]{{3,-1}},1));
    }
}
