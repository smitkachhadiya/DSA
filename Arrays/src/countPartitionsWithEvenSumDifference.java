public class countPartitionsWithEvenSumDifference {

    //  3432. Count Partitions with Even Sum Difference

    //  Method 1 : Using Two Pointer

    public static int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int i=0;i<nums.length;i++) {
            totalSum += nums[i];
        }
        int leftSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;

            if ((leftSum % 2) == (rightSum % 2)) {
                count++;
            }
        }
        return count;
    }

    //  Method 2 : Using Prefix Sum

    public static int countPartitions2(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i : nums) totalSum += i;
        int currentSum = 0;
        int count = 0;
        for(int i = 0;i<n-1;i++){
            currentSum += nums[i];
            totalSum -= nums[i];
            if((totalSum-currentSum)%2==0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{10,10,3,7,6}));
        System.out.println(countPartitions(new int[]{1,3,3}));
    }
}
