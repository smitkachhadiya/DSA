public class splitArrayLargestSum {

    //  410. Split Array Largest Sum

    public static int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int i : nums){
            left = Math.max(left , i);
            right += i;
        }

        while (left <= right){
            int mid = left + (right - left) / 2;
            if(countSubArray(nums,mid) <= k){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int countSubArray(int[] nums, int mid){
        int count = 1, sum = 0;
        for (int i : nums){
            if(sum + i > mid){
                sum = i;
                count++;
            } else{
                sum += i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,2,5,10,8},2));
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
    }

}
