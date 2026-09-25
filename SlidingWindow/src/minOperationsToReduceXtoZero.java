public class minOperationsToReduceXtoZero {

    //  1658. Minimum Operations to Reduce X to Zero

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        int target = total - x;

        if (target < 0) return -1;
        if (target == 0) return n;

        int left = 0;
        int sum = 0;
        int longest = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (left <= right && sum > target)
                sum -= nums[left++];

            if (sum == target)
                longest = Math.max(longest, right - left + 1);
        }

        return longest == -1 ? -1 : n - longest;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,4,2,3},5));
        System.out.println(minOperations(new int[]{5,6,7,8,9},4));
    }
}
