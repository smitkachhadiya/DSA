import java.util.HashMap;
import java.util.Map;

public class maxSumOfPairWithEqualSumOfDigits {
    
    // 2342. Max Sum of a Pair With Equal Sum of Digits

    public static int maximumSum(int[] nums) {
        Map<Integer,Integer> sumMax = new HashMap<>();
        int sum = -1;

        for (int i : nums){
            int digitSum = countDigit(i);
            if (sumMax.containsKey(digitSum)) {
                sum = Math.max(sum ,i + sumMax.get(digitSum));
                if(sumMax.get(digitSum) < i){
                    sumMax.put(digitSum,i);
                }
            }else {
                sumMax.put(digitSum,i);
            }
        }
        return sum;
    }

    public static int countDigit(int digit){
        int sum = 0;
        while (digit != 0){
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {18,43,36,13,7,16,27};
        System.out.println(maximumSum(arr));
    }
}
