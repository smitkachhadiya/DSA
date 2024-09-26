public class findMinInRotatedSortedArray {

    //153. Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums) {
        int left = 0 , right = nums.length-1;
        while (left < right){
            int mid = left + (right-right)/2 ;

            if(nums[mid] > nums[right]){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
