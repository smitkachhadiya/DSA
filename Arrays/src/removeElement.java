public class removeElement {
    // 27. Remove Element

    public static int removeElement(int[] nums, int val) {
        int ans = 0;

        for(int i=0 ; i < nums.length ; i++){
            if(nums[i] != val){
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = removeElement(nums, val);

        // Print the result
        System.out.println("Number of elements not equal to " + val + ": " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
