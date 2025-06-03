import java.util.*;

public class findTheDifferenceOfTwoArrays {

    // 2215. Find the Difference of Two Arrays

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i : nums1){
            set1.add(i);
        }

        for(int i : nums2){
            set2.add(i);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int num : set1){
            if(!set2.contains(num)){
                list1.add(num);
            }
        }

        for(int num : set2){
            if(!set1.contains(num)){
                list2.add(num);
            }
        }

        return Arrays.asList(list1,list2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(findDifference(nums1 , nums2));
    }
}
