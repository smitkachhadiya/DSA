import java.util.Arrays;

public class rotateArray {

    //  189. Rotate Array

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0 , n-1);
        reverse(nums, 0 , k-1);
        reverse(nums, k , n-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
        rotate(new int[]{1,2,3,4,5,6,7},10);
        rotate(new int[]{-1,-100,3,99},2);
    }
}
