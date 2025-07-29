import java.util.Arrays;

public class smallestSubarrayWithMaxBitwiseOR {

    //  2411. Smallest Subarrays With Maximum Bitwise OR

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | nums[i]) == nums[j]) break;
                nums[j] |= nums[i];
                ret[j] = i - j + 1;
            }
        }

        return ret;
    }

    public static int[] smallestSubarrays2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] latest = new int[32];
        Arrays.fill(latest, -1);
        for (int i = n - 1; i >= 0; i--)
        {
            int farthest = i;

            for (int b = 0; b < 32; b++)
            {
                if (((nums[i] >> b) & 1) != 0)
                {
                    latest[b] = i;
                }
                if (latest[b] != -1)
                {
                    farthest = Math.max(farthest, latest[b]);
                }
            }
            result[i] = farthest - i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubarrays(new int[]{1,0,2,1,3}));
        System.out.println(smallestSubarrays(new int[]{1,2}));
    }
}
