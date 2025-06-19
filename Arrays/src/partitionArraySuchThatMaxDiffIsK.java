import java.util.Arrays;

public class partitionArraySuchThatMaxDiffIsK {

    //  2294. Partition Array Such That Maximum Difference Is K

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i=0;

        while (i < nums.length){
            int start = nums[i];
            while (i < nums.length && nums[i] <= start+k){
                i++;
            }
            count++;
        }

        return count;
    }

    public static int partitionArray2(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, count = 0;
        int n = nums.length;
        while (j < n) {
            if (nums[j] - nums[i] > k) {
                count++;
                i = j;
            }
            j++;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3,6,1,2,5},2));
        System.out.println(partitionArray(new int[]{1,2,3},1));
        System.out.println(partitionArray(new int[]{2,2,4,5},0));
    }
}
