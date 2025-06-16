public class maxDiffBetweenIncreasingElements {

    //  2016. Maximum Difference Between Increasing Elements

    public static int maximumDifference(int[] nums) {
        int minValue = nums[0];
        int ans = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minValue) {
                ans = Math.max(ans, nums[i] - minValue);
            }
            minValue = Math.min(minValue, nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7,1,5,4}));
        System.out.println(maximumDifference(new int[]{9,4,3,2}));
        System.out.println(maximumDifference(new int[]{1,5,2,10}));
    }

}
