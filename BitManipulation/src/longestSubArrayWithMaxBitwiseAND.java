public class longestSubArrayWithMaxBitwiseAND {

    //  2419. Longest Subarray With Maximum Bitwise AND

    public static int longestSubarray(int[] nums) {
        int max = 0;
        for (int i : nums){
            max = Math.max(max , i);
        }

        int maxLen = 0;
        int currentLen = 0;
        for (int num : nums) {
            if (num == max) {
                currentLen++;
            } else {
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 0;
            }
        }
        return Math.max(maxLen,currentLen);
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,2,3,3,2,2}));
        System.out.println(longestSubarray(new int[]{1,2,3,3,1,3,3,3,2,2}));
    }
}
