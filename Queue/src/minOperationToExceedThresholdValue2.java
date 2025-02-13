import java.util.PriorityQueue;

public class minOperationToExceedThresholdValue2 {

    // 3066. Minimum Operations to Exceed Threshold Value II

    public static int minOperations(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (long i : nums){
            queue.add(i);
        }

        while (queue.size() > 1){
            if (queue.peek() >= k){
                break;
            }
            long a = queue.remove();
            long b = queue.remove();
//            System.out.println(a + " " + b);
            queue.add(Math.min(a,b)*2 + Math.max(a,b));
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,11,10,1,3};
        System.out.println(minOperations(arr,10));
    }
}
