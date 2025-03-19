public class minOperationToMakeBinaryArrayEqualToOne1 {

    //  3191. Minimum Operations to Make Binary Array Elements Equal to One I

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i < n - 2; ++i) {
            if (nums[i] == 1) {
                continue;
            }
            flipWindow(nums, i);
            operations++;
        }

        if (nums[n - 2] == 0 || nums[n - 1] == 0) {
            return -1;
        }

        return operations;
    }

    private static void flipWindow(int[] nums, int i) {
        nums[i] ^= 1;
        nums[i+1] ^= 1;
        nums[i+2] ^= 1;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0,1,1,1,0,0}));
        System.out.println(minOperations(new int[]{0,1,1,1}));
    }
}
