public class maxCountOfPositiveAndNegativeInteger {

    //  2529. Maximum Count of Positive Integer and Negative Integer

    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int lb = lowerBound(nums, 0);
        int ub = upperBound(nums, 0);

        return Math.max(lb, n - ub);
    }

    private static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,-1,1,2,3};
        System.out.println(maximumCount(arr));
    }
}
