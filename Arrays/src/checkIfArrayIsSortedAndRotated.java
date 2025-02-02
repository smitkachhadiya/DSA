public class checkIfArrayIsSortedAndRotated {

    // 1752. Check if Array Is Sorted and Rotated

    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] > nums[ (i + 1) % n] ){
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,1,2,3};
        System.out.println(check(arr));
    }
}
