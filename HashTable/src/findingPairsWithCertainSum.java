import java.util.HashMap;
import java.util.Map;

class FindSumPairs {

    //  1865. Finding Pairs With a Certain Sum

    private int[] arr1;
    private int[] arr2;
    private Map<Integer, Integer> eleFreq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.arr1 = nums1;
        this.arr2 = nums2.clone();
        this.eleFreq = new HashMap<>();
        for (int ele : nums2) {
            eleFreq.put(ele, eleFreq.getOrDefault(ele, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = arr2[index];
        eleFreq.put(oldVal, eleFreq.get(oldVal) - 1);
        arr2[index] += val;
        int newVal = arr2[index];
        eleFreq.put(newVal, eleFreq.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int ele : arr1) {
            int target = tot - ele;
            res += eleFreq.getOrDefault(target, 0);
        }
        return res;
    }
}

public class findingPairsWithCertainSum {
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(
                new int[]{1, 1, 2, 2, 2, 3},
                new int[]{1, 4, 5, 2, 5, 4}
        );

        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }
}