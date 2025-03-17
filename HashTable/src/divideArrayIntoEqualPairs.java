import java.util.HashSet;
import java.util.Set;

public class divideArrayIntoEqualPairs {

    //  2206. Divide Array Into Equal Pairs

    public static boolean divideArray(int[] nums) {
        Set<Integer> remaining = new HashSet<>();
        for (int ele : nums) {
            if (remaining.contains(ele)) {
                remaining.remove(ele);
            } else {
                remaining.add(ele);
            }
        }
        return remaining.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(divideArray(new int[] {3,2,3,2,2,2}));
        System.out.println(divideArray(new int[] {1,2,3,4}));
    }
}
