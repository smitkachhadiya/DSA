import java.util.Arrays;

public class validTriangleNumber {

    //  611. Valid Triangle Number

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,5,6,8,9,1,2,5}));
    }
}
