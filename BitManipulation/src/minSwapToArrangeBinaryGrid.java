public class minSwapToArrangeBinaryGrid {

    //  1536. Minimum Swaps to Arrange a Binary Grid

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;
            while (j < n && zeros[j] < needed) j++;

            if (j == n) return -1;
            while (j > i) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                j--;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[][]{{0,0,1},{1,1,0},{1,0,0}}));
        System.out.println(minSwaps(new int[][]{{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}}));
    }
}
