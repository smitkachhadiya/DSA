import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestHermoniousSubsequence {

    //  594. Longest Harmonious Subsequence

    public static int findLHS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (nums[i] - nums[j] > 1){
                j++;
            }
            if(nums[i] - nums[j] == 1){
                ans = Math.max(ans, i-j+1);
            }
        }

        return ans;
    }

    //  Using HashMap -----------------------------------------------------------

    public static int findLHS2(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
        }

        int ans = 0;
        for (int i : map.keySet()){
            if(map.containsKey(i+1)){
                ans = Math.max(map.get(i) + map.get(i+1) , ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(findLHS(new int[]{1,2,3,4}));
        System.out.println(findLHS(new int[]{1,1,1,1}));
    }
}
