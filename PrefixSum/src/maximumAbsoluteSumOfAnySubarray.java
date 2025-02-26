public class maximumAbsoluteSumOfAnySubarray {

    //  1749. Maximum Absolute Sum of Any Subarray

    public static int maxAbsoluteSum(int[] nums) {
        int min = 0;
        int max = 0;
        int preSum = 0;
        for (int n : nums){
            preSum = preSum + n;
            min = Math.min(preSum , min);
            max = Math.max(preSum , max);
        }
        return max - min;
    }

    public static void main(String[] args) {
        int[] arr = {2,-5,1,-4,3,-2};
        System.out.println(maxAbsoluteSum(arr));
    }
}
