import java.util.Arrays;

public class minimumLimitOfBallInABag {

    //  1760. Minimum Limit of Balls in a Bag

    public static int minimumSize(int[] nums, int maxOperations) {
        int low  = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        int result = high;

        while(low<= high){
            int mid =low + (high-low)/2;

            if(ispossible(nums,maxOperations,mid)){
                result = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }


    private static boolean ispossible(int[] nums, int maxOperations, int penalty) {
        int ops = 0;
        for (int num : nums) {
            ops += (num - 1) / penalty;
            if (ops > maxOperations) {
                return false;
            }
        }
        return true;
    }

    // Takes more time

    public static int minimumSize2(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        int ans = 0;

        for (int i : nums){
            right = Math.max(i , right);
        }

        while (left <= right){
            int mid = left + (right - left)/2;
            long count =0;

            for (int i = 0; i < nums.length; i++) {
                count += (int) Math.ceil((double) nums[i] /(double) mid) -1;
            }

            if(count <= maxOperations){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{9},2));
        System.out.println(minimumSize(new int[]{2,4,8,2},4));
        System.out.println(minimumSize(new int[]{1000000000,1000000000,1000000000},1000000000));
    }
}
