import java.util.Arrays;

public class maxSubarraySumWithLenghtDivisibleByK {

    //  3381. Maximum Subarray Sum With Length Divisible by K

    public static long maxSubarraySum(int[] nums, int k) {
        long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE / 2);
        minPref[k - 1] = 0;

        long sum = 0, res = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = i % k;
            res = Math.max(res, sum - minPref[r]);
            minPref[r] = Math.min(minPref[r], sum);
        }

        return res;
    }

    //  Method 2 :- Sliding Window

    public static long maxSubarraySum2(int[] nums, int k) {
        long[] arr = new long[nums.length];
        long ans = Integer.MIN_VALUE;
        long window = 0L;
        for(int i = 0;i < k && i < nums.length;i++){
            window += nums[i];
        }
        arr[k-1] = window;
        ans = arr[k-1];
        for(int i = k;i < nums.length;i++){
            window += nums[i];
            window -= nums[i-k];
            arr[i] = Math.max(window, window + arr[i-k]);
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{-8,-6,-4,-4,2,4,5,6,8,13,15},4));
        System.out.println(maxSubarraySum(new int[]{-10,-1},1));
        System.out.println(maxSubarraySum(new int[]{2,1},1));
    }
}
