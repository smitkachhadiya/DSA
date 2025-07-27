public class countHillsAndValleysInAnArray {

    //  2210. Count Hills and Valleys in an Array

    public static int countHillValley(int[] nums) {
        int ans = 0;
        int j = 0;
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if ((nums[j] < nums[i] && nums[i] > nums[i + 1]) || (nums[j] > nums[i] && nums[i] < nums[i + 1])) {
                ans++;
                j = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{6,6,5,5,4,1}));
        System.out.println(countHillValley(new int[]{2,4,1,1,6,5}));
    }
}
