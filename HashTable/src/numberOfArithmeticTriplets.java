import java.util.HashSet;
import java.util.Set;

public class numberOfArithmeticTriplets {

    // 2367. Number of Arithmetic Triplets

    public static int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int i : nums){
            set.add(i);
        }

        for(int i : nums){
            if(set.contains(i - diff) && set.contains(i + diff)){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {0, 1, 4, 6, 7, 10};
        int diff1 = 3;
        System.out.println("Output: " + arithmeticTriplets(nums1, diff1)); // Output: 2

        int[] nums2 = {4, 5, 6, 7, 8, 9};
        int diff2 = 2;
        System.out.println("Output: " + arithmeticTriplets(nums2, diff2)); // Output: 2
    }
}
