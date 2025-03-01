import java.util.Arrays;

public class applyOperationToArray {

    //  2460. Apply Operations to an Array

    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int nonZero = 0;

        for (int i = 0; i < n; ++i) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZero];
                nums[nonZero] = temp;
                nonZero++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,0};
        System.out.println(Arrays.toString(applyOperations(arr)));
    }
}
