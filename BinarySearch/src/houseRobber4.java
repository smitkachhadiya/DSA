import java.util.Arrays;

public class houseRobber4 {

    //  2560. House Robber IV

    public static int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssign(mid, nums, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canAssign(int maxVal, int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxVal) {
                count++;
                i++;
            }
        }
        return count >= k;
    }

    public static void main(String[] args) {
        System.out.println(minCapability(new int[] {2,3,5,9} , 2));
        System.out.println(minCapability(new int[] {2,7,9,3,1} , 2));
    }
}
