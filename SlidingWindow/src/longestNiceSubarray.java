public class longestNiceSubarray {

    //  2401. Longest Nice Subarray

    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        int maxWindowSize = 0;
        int xorSum = 0;
        int currSum = 0;

        while (right < n) {
            currSum += nums[right];
            xorSum ^= nums[right];

            while (xorSum != currSum) {
                currSum -= nums[left];
                xorSum ^= nums[left];
                left++;
            }

            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
            right++;
        }

        return maxWindowSize;
    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));
        System.out.println(longestNiceSubarray(new int[]{3,1,5,11,13}));
    }
}
