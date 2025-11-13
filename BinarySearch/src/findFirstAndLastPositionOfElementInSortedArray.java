public class findFirstAndLastPositionOfElementInSortedArray {

    //  34. Find First and Last Position of Element in Sorted Array

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums,target),findLast(nums,target)};
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid-1;
            } else{
                left = mid + 1;
            }
            if(nums[mid] == target){
                ans = mid;
            }
        }
        return ans;
    }

    private static int findLast(int[] nums, int target) {
        int left = 0 , right = nums.length-1;
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid-1;
            } else{
                left = mid + 1;
            }
            if(nums[mid] == target){
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,7,7,8,8,10},8));
        System.out.println(searchRange(new int[]{5,7,7,8,8,10},6));
    }
}
