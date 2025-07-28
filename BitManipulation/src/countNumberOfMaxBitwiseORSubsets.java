public class countNumberOfMaxBitwiseORSubsets {

    //  2044. Count Number of Maximum Bitwise-OR Subsets

    static int count = 0;
    static int maxOr = 0;

    public static int countMaxOrSubsets(int[] nums) {
        for(int num:nums){
            maxOr |= num;
        }
        helper(nums,0,0);
        return count;
    }

    public static void helper(int[] nums , int index , int currOr){
        if (index == nums.length){
            if(maxOr == currOr){
                count++;
            }
            return;
        }
        helper(nums , index+1 , (nums[index] | currOr));
        helper(nums , index+1 , currOr);
    }

    // Using BackTracking -------------------------------------------------------------------
    public static int countMaxOrSubsets2(int[] nums) {
        int maxOr=0;
        for(int a:nums){
            maxOr |= a;
        }
        backtrack(nums,maxOr,0,0);
        return count;
    }

    public static void backtrack(int[] nums,int targetOr, int currOr,int index){
        if(currOr==targetOr){
            count = count + (1<<(nums.length-index));
            return;
        }
        for(int i=index;i<nums.length;i++){
            backtrack(nums,targetOr,currOr|nums[i],i+1);
        }
    }

    //  Using DP -------------------------------------------------------------------------
    public static int countMaxOrSubsets3(int[] nums) {
        int maxOr = 0;
        int[] dp = new int[100001];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = maxOr; i >= 0; i--) {
                dp[i | num] += dp[i];
            }
            maxOr |= num;
        }

        return dp[maxOr];
    }

    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3,1}));
        System.out.println(countMaxOrSubsets(new int[]{2,2,2}));
        System.out.println(countMaxOrSubsets(new int[]{3,2,1,5}));
    }
}
