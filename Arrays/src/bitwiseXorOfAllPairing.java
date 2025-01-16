public class bitwiseXorOfAllPairing {

    // 2425. Bitwise XOR of All Pairings

    public static int xorAllNums(int[] nums1, int[] nums2) {
        int ans1 = 0;
        int ans2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 % 2 != 0){
            for(int i : nums2){
                ans1 ^= i;
            }
        }

        if(n2 % 2 != 0){
            for(int i : nums1){
                ans2 ^= i;
            }
        }

        return ans1 ^ ans2;
    }

    public static void main(String[] args) {
        int[] num1 = {2,1,3};
        int[] num2 = {10,2,5,0};
        System.out.println(xorAllNums(num1,num2));
    }
}
