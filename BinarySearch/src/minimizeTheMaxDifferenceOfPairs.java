import java.lang.reflect.Array;
import java.util.Arrays;

public class minimizeTheMaxDifferenceOfPairs {

    //  2616. Minimize the Maximum Difference of Pairs

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1];
        int ans = Integer.MAX_VALUE;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(nums,mid,p)){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid +1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] nums , int val , int p){
        int count = 0;
        int i = 1;
        while (i < nums.length){
            if(nums[i] - nums[i-1] <= val){
                count++;
                i += 2;
            } else{
                i++;
            }
        }

        return count>=p;
    }

    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[]{10,1,2,7,1,3},2));
        System.out.println(minimizeMax(new int[]{4,2,1,2},1));
    }
}
