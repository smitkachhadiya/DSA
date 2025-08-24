import java.util.ArrayList;
import java.util.List;

public class longestSubarrayOf1sAfterDeletingOneElement {
    
    //  1493. Longest Subarray of 1's After Deleting One Element

    public static int longestSubarray(int[] nums) {
        int left = 0, right = 0, d = -1, max = 0, len = nums.length;
        while (right < len) {
            if (nums[right] == 0) {
                if (d == -1) {
                    d = right;
                    right++;
                } else {
                    max = Math.max(max, right - left - 1);
                    left = d + 1;
                    d = -1;
                }
            } else {
                right++;
            }
        }

        return Math.max(max, right - left - 1);
    }

    // Using DP ----------------------------------------------------------------

    public static int longestSubarray2(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                dp.add(count);
                count = 0;
            }
        }
        dp.add(count);

        if (dp.size() == 1) {
            return dp.get(0) - 1;
        }

        int max = 0;
        for (int i = 0; i < dp.size() - 1; i++) {
            max = Math.max(max, dp.get(i) + dp.get(i + 1));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,0,1,1,1}));
        System.out.println(longestSubarray(new int[]{1,1,1}));
    }
}
