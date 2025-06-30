import java.util.Arrays;
import java.util.Map;

public class numOfSubseqThatSatisfyTheGivenSumCondition {

    //  1498. Number of Subsequences That Satisfy the Given Sum Condition

    public static int numSubseq(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0 , r = n-1;

        int[] p = new int[n];
        p[0]=1;
        for(int i=1;i<r+1;i++){
            p[i] = (p[i-1]*2)%1000000007;
        }

        while (l <= r){
            if(nums[l] + nums[r] > target){
                r--;
            } else {
                ans += p[r-l];
                ans%=1000000007;
                l++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3,5,6,7},9));
        System.out.println(numSubseq(new int[]{3,3,6,8},10));
        System.out.println(numSubseq(new int[]{2,3,3,4,6,7},12));
    }

}
