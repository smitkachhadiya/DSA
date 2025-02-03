import java.sql.Array;
import java.sql.SQLOutput;

public class longestStriclyIncreasingOrDecreasingArray {
    
    // 3105. Longest Strictly Increasing or Strictly Decreasing Subarray

    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int incLen = 1, decLen = 1, maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1;
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1;
            } else {
                incLen = 1;
                decLen = 1;
            }

            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        System.out.println(longestMonotonicSubarray(arr));
    }

}
