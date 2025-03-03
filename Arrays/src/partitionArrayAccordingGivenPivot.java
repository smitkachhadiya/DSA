import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionArrayAccordingGivenPivot {

    //  2161. Partition Array According to Given Pivot

    public static int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int m=0;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                ans[m]=nums[i];
                m++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                ans[m]=nums[i];
                m++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                ans[m]=nums[i];
                m++;
            }
        }
        return ans;
    }

    public static int[] pivotArray2(int[] nums, int pivot) {
        List<Integer> small = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                small.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        int index = 0;
        for (int num : small) nums[index++] = num;
        for (int num : equal) nums[index++] = num;
        for (int num : greater) nums[index++] = num;

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {9,12,5,10,14,3,10};
        System.out.println(Arrays.toString(pivotArray(arr,10)));
    }
}
