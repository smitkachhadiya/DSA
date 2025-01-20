import java.util.HashMap;

public class majorityElement {

    // 169. Majority Element

    public static int majorityElement(int[] nums) {
        HashMap<Integer , Integer> count = new HashMap<>();
        int majority = nums.length/2;

        for(int n : nums){
            count.put(n , count.getOrDefault(n,0)+1);
            if (count.get(n) >= majority){
                return n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        majorityElement me = new majorityElement();
        int[] nums1 = {3, 2, 3 ,1};
        System.out.println(me.majorityElement(nums1));
    }
}
