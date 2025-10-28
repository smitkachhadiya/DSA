public class makeArrayElementEqualToZero {

    //  3354. Make Array Elements Equal to Zero

    public static int countValidSelections(int[] nums) {
        int count = 0, len = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        int halfSum = 0;
        for (int i = 0; i < len; i++) {
            halfSum += nums[i];
            if (nums[i] == 0) {

                if (2 * halfSum == sum) {
                    count += 2;
                } else if (Math.abs(sum - 2*halfSum) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countValidSelections2(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
            right[n - i - 1] = right[n - i] + nums[n - i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;
            if (left[i] == right[i]) count += 2;
            else if (Math.abs(left[i] - right[i]) == 1) count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[]{1,0,2,0,3}));
        System.out.println(countValidSelections(new int[]{2,3,4,0,4,1,0}));
    }
}
