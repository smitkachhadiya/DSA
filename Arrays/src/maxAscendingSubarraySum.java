public class maxAscendingSubarraySum {

    // 1800. Maximum Ascending Subarray Sum

    public static int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                currSum += nums[i];
            }else {
                currSum = nums[i];
            }
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        System.out.println(maxAscendingSum(arr));
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }
}
