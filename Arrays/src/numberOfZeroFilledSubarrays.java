public class numberOfZeroFilledSubarrays {

    //  2348. Number of Zero-Filled Subarrays

    public static long zeroFilledSubarray(int[] nums) {
        long cnt = 0, streak = 0;
        for (int num : nums) {
            streak = (num == 0) ? streak + 1 : 0;
            cnt += streak;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
    }
}
