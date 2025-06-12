public class maxDiffBetweenAdjacentInCircularArray {

    //  3423. Maximum Difference Between Adjacent Elements in a Circular Array

    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, Math.abs(nums[i + 1] - nums[i]));
        }
        max = Math.max(max, Math.abs(nums[n - 1] - nums[0]));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{1,2,4}));
        System.out.println(maxAdjacentDistance(new int[]{-5,-10,-5}));
    }

}
