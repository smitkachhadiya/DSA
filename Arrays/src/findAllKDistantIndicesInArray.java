import java.util.ArrayList;
import java.util.List;

public class findAllKDistantIndicesInArray {

    //  2200. Find All K-Distant Indices in an Array

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == key){
//                System.out.println(i);
                int l = Math.max(index , i-k);
                index = Math.min(n-1,i+k) + 1;
                for (int j = l; j < index; ++j) {
                    ans.add(j);
                }
            }
        }
        return ans;
    }

    public static List<Integer> findKDistantIndices2(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key){
                System.out.println(i);
                for (int j = index; j < nums.length; j++) {
                    if(Math.abs(i-j) <= k && !ans.contains(j)){
                        ans.add(j);
                    }
                }
                index = ans.get(ans.size()-1);
//                System.out.println(index);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3,4,9,1,3,9,5},9,1));
        System.out.println(findKDistantIndices(new int[]{2,2,2,2,2},2,2));
        System.out.println(findKDistantIndices(new int[]{3,4,9,1,3,9,5,6,8,5,5,6,9,5,2,0,1},9,1));
    }

}
