import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class containsDublicate {
    // 217. Contains Duplicate

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0 ; i < nums.length -1 ; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    // method 2 :
    public boolean containsDublicate2(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }

    // method : 3
    public boolean containsDuplicate3(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1)
                return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
