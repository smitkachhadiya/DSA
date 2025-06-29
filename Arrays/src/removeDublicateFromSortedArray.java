public class removeDublicateFromSortedArray {

    //  26. Remove Duplicates from Sorted Array

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0 ; i< n-1 ; i++){
            if(nums[i] != nums[i+1]){
                nums[ans+1] = nums[i+1];
                ans++;
            }
        }
        return (ans+1);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
