import java.util.Arrays;

public class findMissingAndRepeatedValues {

    //  2965. Find Missing and Repeated Values

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeating = 0 , missing = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = Math.abs(grid[i][j]);
                int row = (curr - 1) / n;
                int column = (curr - 1) % n;

                if(grid[row][column] < 0){
                    repeating = Math.abs(curr);
                } else{
                    grid[row][column] *= -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] > 0){
                    missing = i * n + (j +1);
                    break;
                }
            }
        }

        return new int[]{repeating , missing};
    }

    public static void main(String[] args) {
        int[][] arr = {
                {9,1,7},
                {8,9,2},
                {3,4,6}
        };

        System.out.println(Arrays.toString(findMissingAndRepeatedValues(arr)));
    }
}
