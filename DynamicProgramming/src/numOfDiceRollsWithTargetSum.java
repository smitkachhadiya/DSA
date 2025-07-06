import java.util.Arrays;

public class numOfDiceRollsWithTargetSum {

    //  1155. Number of Dice Rolls With Target Sum

    static int mod = 1000000007;

    public static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(dp, n, k, target);
    }

    private static int helper(int[][] dp, int n, int k, int target) {
        if (target == 0 && n == 0) {
            return 1;
        }
        if (n == 0 || target <= 0) {
            return 0;
        }

        if (dp[n][target] != -1) {
            return (int) (dp[n][target] % mod);
        }
        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways = (ways + helper(dp, n - 1, k, target - i)) % mod;
        }
        dp[n][target] = ways % mod;
        return dp[n][target];
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3));
        System.out.println(numRollsToTarget(30,30,500));
    }
}
