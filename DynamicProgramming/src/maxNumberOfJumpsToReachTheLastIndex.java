import java.util.Arrays;

public class maxNumberOfJumpsToReachTheLastIndex {

    //  2770. Maximum Number of Jumps to Reach the Last Index

    public static int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if ((long)nums[i] - target <= (long)nums[j]
                        && (long)nums[j] <= (long)nums[i] + target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maximumJumps(new int[]{1,3,6,4,1,2}, 2));
        System.out.println(maximumJumps(new int[]{1,3,6,4,1,2}, 3));
        System.out.println(maximumJumps(new int[]{1,3,6,4,1,2}, 0));
    }
}
