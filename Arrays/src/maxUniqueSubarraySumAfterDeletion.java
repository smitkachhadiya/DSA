public class maxUniqueSubarraySumAfterDeletion {

    //  3487. Maximum Unique Subarray Sum After Deletion

    public static int maxSum(int[] nums) {
        boolean negative = true;
        int max = Integer.MIN_VALUE;

        for (int n : nums){
            if(n >= 0){
                negative = false;
            }
            if(n > max){
                max = n;
            }
        }

        if(negative){
           return max;
        }

        boolean[] seen = new boolean[101];
        for (int n : nums) {
            if (n >= 0 && n < 101) {
                seen[n] = true;
            }
        }

        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (seen[i]) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1,2,-1,-2,1,0,-1}));
        System.out.println(maxSum(new int[]{1,2,3,4,5}));
    }
}
