import java.util.Arrays;

public class waysToExpressIntegerAsSumOfPowers {

    //  2787. Ways to Express an Integer as Sum of Powers

    static final int MOD = 1_000_000_007;

    public static int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
//        System.out.println(Arrays.toString(dp));
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int power = (int) Math.pow(i, x);
            for (int sum = n; sum >= power; sum--) {
                dp[sum] = (dp[sum] + dp[sum - power]) % MOD;
            }
//            System.out.println(Arrays.toString(dp));
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(20,2));
        System.out.println(numberOfWays(10,2));
        System.out.println(numberOfWays(40 ,3));
    }
}
