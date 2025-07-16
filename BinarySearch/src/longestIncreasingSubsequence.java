import java.util.ArrayList;
import java.util.List;

public class longestIncreasingSubsequence {

    //  300. Longest Increasing Subsequence

    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i : nums){
            if(list.isEmpty() || list.get(list.size()-1) < i){
                list.add(i);
            } else {
                int index = getIndex(list,i);
                list.set(index , i);
            }
        }
        return list.size();
    }

    private static int getIndex(List<Integer> list, int target) {
        int left = 0;
        int right = list.size()-1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target){
                return mid;
            } else if(list.get(mid) > target){
                right = mid - 1;
            } else {
                left = mid +1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
