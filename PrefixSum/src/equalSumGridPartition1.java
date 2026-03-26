public class equalSumGridPartition1 {

    //  3546. Equal Sum Grid Partition I

    public static boolean canPartitionGrid(int[][] grid) {
        final long[] rowSum = new long[grid.length];
        long sum = 0;
        for (int i = 0; i < rowSum.length; ++i) {
            for (final int n : grid[i]) {
                rowSum[i] += n;
            }
            sum += rowSum[i];
        }
        if ((sum % 2) != 0) {
            return false;
        }
        sum /= 2;
        long total = 0;
        for (int i = 0; i < rowSum.length - 1 && total < sum; ++i) {
            total += rowSum[i];
        }
        if (total == sum) {
            return true;
        }
        total = 0;
        for (int j = 0; j < grid[0].length - 1 && total < sum; ++j) {
            for (int i = 0; i < grid.length; ++i) {
                total += grid[i][j];
            }
        }
        return total == sum;
    }

    public static boolean canPartitionGrid2(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long[] rowSum = new long[m];
        long[] colSum = new long[n];
        long total = 0;

        // Compute sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                total += grid[i][j];
            }
        }

        if (total % 2 != 0) return false;

        if (check(rowSum, total)) return true;
        if (check(colSum, total)) return true;

        return false;
    }

    private static boolean check(long[] arr, long total) {
        long left = arr[0];
        long right = total - left;

        for (int i = 1; i < arr.length; i++) {
            if (left == right) return true;
            else if (left > right) return false;
            left += arr[i];
            right -= arr[i];
        }

        return false;
    }

public static void main(String[] args) {
        System.out.println(canPartitionGrid(new int[][]{{1,4},{2,3}}));
        System.out.println(canPartitionGrid(new int[][]{{1,3},{2,4}}));
    }
}
