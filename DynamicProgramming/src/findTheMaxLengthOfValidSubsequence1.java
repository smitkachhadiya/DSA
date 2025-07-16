public class findTheMaxLengthOfValidSubsequence1 {

    //  3201. Find the Maximum Length of Valid Subsequence I

    public static int maximumLength(int[] nums) {
        int odd = 0 , even = 0;
        int oddDp = 0, evenDp = 0;

        for (int i : nums){
            if(i%2 == 0){
                even++;
                evenDp = Math.max(evenDp,oddDp + 1);
            } else{
                odd++;
                oddDp = Math.max(oddDp,evenDp + 1);
            }
        }
        return Math.max(Math.max(odd,even),Math.max(oddDp,evenDp));
    }

    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1,2,3,4}));
        System.out.println(maximumLength(new int[]{1,2,1,1,2,1,2}));
        System.out.println(maximumLength(new int[]{1,3}));
    }
}
