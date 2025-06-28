import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class findSubsequenceOfLengthKWithTheLargestSum {
    
    //  2099. Find Subsequence of Length K With the Largest Sum

    //  Using PriorityQueue
    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i],i});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] indices = pq.toArray(new int[0][0]);
        Arrays.sort(indices, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices[i][1]];
        }
        return result;
    }

    public static int[] maxSubsequence2(int[] nums, int k) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs , (a,b) -> b[0] - a[0]);
        int[][] top = Arrays.copyOfRange(pairs , 0 , k);

        Arrays.sort(top , Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = top[i][0];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{2,1,3,3},2)));
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-1,-2,3,4},3)));
        System.out.println(Arrays.toString(maxSubsequence(new int[]{50,-75},2)));
    }
}
