import java.util.ArrayList;
import java.util.List;

// 303. Range Sum Query - Immutable

class NumArray {
    List<Integer> prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new ArrayList<>();
        prefixSum.add(0);

        for (int i : nums){
            prefixSum.add(prefixSum.get(prefixSum.size() -1 ) + i);
//            System.out.println(" prefixSum : " + prefixSum);
        }
    }

    public int sumRange(int left, int right) {
//        System.out.println("left : " + prefixSum.get(left+1) + " right : " + prefixSum.get(right+1));
        return (prefixSum.get(right + 1) - prefixSum.get(left));
    }
}

public class rangeSumQuery_Immutable {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(arr);
        System.out.println(numArray.sumRange(0, 2));   // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5));   // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5));   // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}
