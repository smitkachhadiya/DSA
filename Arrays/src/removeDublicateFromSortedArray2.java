import java.util.Arrays;

public class removeDublicateFromSortedArray2 {

    //  80. Remove Duplicates from Sorted Array II

    public static int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,2,3}));
    }
}
