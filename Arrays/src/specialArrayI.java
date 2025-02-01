public class specialArrayI {

    // 3151. Special Array I

    public static boolean isArraySpecial(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if((nums[i] % 2) == (nums[i+1]%2)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2};
        System.out.println(isArraySpecial(arr));
    }
}
