import java.util.HashMap;
import java.util.Map;

public class deleteAndEarn {

    //  740. Delete and Earn

    public static int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums){
            max = Math.max(max , i);
            map.put(i , map.getOrDefault(i , 0) +1);
        }

        int[] dp = new int[max +1];
        dp[0] = 0;
        dp[1] = map.getOrDefault(1,0);

        for (int i = 2; i < max + 1; i++) {
            int iSum = i * map.getOrDefault(i,0);
            dp[i] = Math.max(dp[i-1] , dp[i-2] + iSum);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
        System.out.println(deleteAndEarn(new int[]{1,4,8,2,6,8,3}));
    }

}
