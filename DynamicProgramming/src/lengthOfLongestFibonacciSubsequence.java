import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestFibonacciSubsequence {

    //  873. Length of Longest Fibonacci Subsequence

    public static int lenLongestFibSubseq(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int[][] dp = new int[len][len];
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(arr[i],i);
            for (int j = i+1; j < len; j++) {
                dp[i][j] = 2;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = arr[i] + arr[j];
                if(map.containsKey(temp)){
                    int index = map.get(temp);
                    dp[j][index] = dp[i][j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result = Math.max(result,dp[i][j]);
            }
        }

        return result == 2 ? 0 : result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(arr));
    }
}
