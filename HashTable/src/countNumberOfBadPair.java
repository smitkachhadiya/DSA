import java.util.HashMap;

public class countNumberOfBadPair {

    // 2364. Count Number of Bad Pairs

    public static long countBadPairs(int[] nums) {
        long n = nums.length;
        HashMap<Integer, Integer> pairs = new HashMap<>();
        long goodPairs = 0;
        for (int i = 0; i < n; ++i) {
            int key = nums[i] - i;
            if (pairs.containsKey(key)) {
                goodPairs += pairs.get(key);
            }
            pairs.put(key, pairs.getOrDefault(key, 0) + 1);
        }

        return n * (n - 1) / 2 - goodPairs;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(countBadPairs(nums));
    }
}
