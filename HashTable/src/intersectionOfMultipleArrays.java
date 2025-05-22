import java.util.*;

public class intersectionOfMultipleArrays {

    // 2248. Intersection of Multiple Arrays

    public static List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                freq.put(nums[i][j],freq.getOrDefault(nums[i][j] , 0)+1);
            }
        }

        for (int key : freq.keySet()){
            if (freq.get(key) == nums.length){
                ans.add(key);
            }
        }
//        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{10,3,1,4,2},{10,1,2,3,4},{10,3,4,5,1},{10,3,4,1,2}};
        System.out.println(intersection(nums));
    }
}
