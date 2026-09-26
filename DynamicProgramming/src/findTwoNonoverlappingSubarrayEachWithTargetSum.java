public class findTwoNonoverlappingSubarrayEachWithTargetSum {

    //  1477. Find Two Non-overlapping Sub-arrays Each With Target Sum

    public static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int sum = 0, start = 0, ans = n + 1, min = n;
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            sum += arr[i];

            while (sum > target)
                sum -= arr[start++];

            if (sum == target) {
                if (start > 0 && dp[start - 1] != n) {
                    ans = Math.min(ans, i - start + 1 + dp[start - 1]);
                }
                min = Math.min(min, i - start + 1);
            }
            dp[i] = min;
        }
        return ans == n + 1 ? - 1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minSumOfLengths(new int[]{3,2,2,4,3}, 3));
        System.out.println(minSumOfLengths(new int[]{7,3,4,7}, 7));
    }
}
