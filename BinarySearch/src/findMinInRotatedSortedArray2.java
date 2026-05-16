public class findMinInRotatedSortedArray2 {

    //  154. Find Minimum in Rotated Sorted Array II

    public static int findMin(int[] nums) {
        int n = nums.length - 1;
        int last = nums[n];
        int left = 0, right = n;

        while (left < n && nums[left] == last)
            left++;

        while (left < right) {
            int mid = left + right >> 1;

            if (nums[mid] > last)
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,2,2,0,1}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
