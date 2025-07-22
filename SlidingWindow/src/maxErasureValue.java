import java.util.HashSet;
import java.util.Set;

public class maxErasureValue {

    //  1695. Maximum Erasure Value

    public static int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int start = 0 , currentSum = 0;
        int[] arr = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            currentSum += current;
            arr[current]++;

            while (arr[current] > 1){
                currentSum -= nums[start];
                arr[nums[start]]--;
                start++;
            }
            ans = Math.max(ans,currentSum);
        }
        return ans;
    }

    public static int maximumUniqueSubarray2(int[] nums) {
        int ans = 0;
        int start = 0 , currentSum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            while (set.contains(nums[i])){
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }

            currentSum += nums[i];
            set.add(nums[i]);
            ans = Math.max(ans,currentSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{5,6,8,9,2,3,1,4,5}));
    }
}
