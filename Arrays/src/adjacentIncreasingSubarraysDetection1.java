import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class adjacentIncreasingSubarraysDetection1 {

    //  3349. Adjacent Increasing Subarrays Detection I

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int knew = k - 1;
        if (knew == 0) return true;
        for (int j = k + 1; j < nums.size(); j++) {
            if (nums.get(j) > nums.get(j - 1) && nums.get(j - k) > nums.get(j - k - 1)) {
                knew--;
            } else {
                knew = k - 1;
            }
            if (knew == 0) return true;
        }
        return false;
    }

    public static boolean hasIncreasingSubarrays2(List<Integer> nums, int k) {
        int n = nums.size();
        int inc = 1, prevInc = 0, maxLen = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) inc++;
            else {
                prevInc = inc;
                inc = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc >> 1, Math.min(prevInc, inc)));
            if (maxLen >= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasIncreasingSubarrays(new ArrayList<>(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)), 3));
    }
}
