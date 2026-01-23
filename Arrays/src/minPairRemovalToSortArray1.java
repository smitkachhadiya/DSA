import java.util.ArrayList;
import java.util.List;

public class minPairRemovalToSortArray1 {

    //  3507. Minimum Pair Removal to Sort Array I

    public static int minimumPairRemoval(int[] nums) {
        int n = nums.length, count = 0;

        while(n > 1) {
            int minSum = Integer.MAX_VALUE, minIdx = -1;
            boolean decreasing = true;
            for(int i = 1; i < n; ++i) {
                if(nums[i - 1] + nums[i] < minSum) {
                    minSum = nums[i - 1] + nums[i];
                    minIdx = i - 1;
                }
                if(nums[i - 1] > nums[i]) decreasing = false;
            }
            if(decreasing) return count;
            nums[minIdx] = minSum;
            for(int i = minIdx + 1; i < n - 1; ++i)
                nums[i] = nums[i + 1];

            count++;
            n--;
        }
        return count;
    }

    public static int minimumPairRemoval1(int[] nums) {
        List<Long> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add((long) num);
        }
        int ops = 0;
        while (true) {
            boolean isSorted = true;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) return ops;
            long minSum = -1;
            int minIdx = -1;
            for (int i = 0; i < arr.size() - 1; i++) {
                long currentSum = arr.get(i) + arr.get(i + 1);
                if (minIdx == -1 || currentSum < minSum) {
                    minSum = currentSum;
                    minIdx = i;
                }
            }
            arr.set(minIdx, minSum);
            arr.remove(minIdx + 1);
            ops++;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5,2,3,1}));
        System.out.println(minimumPairRemoval(new int[]{5,2,3,1,8,2,5,6}));
    }
}
