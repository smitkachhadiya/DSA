import java.util.PriorityQueue;

public class lastStoneWeight {

    //  1046. Last Stone Weight

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int i : stones){
            pq.offer(i);
        }

        while (pq.size() > 1){
            pq.offer(pq.poll()-pq.poll());
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeight(new int[]{2}));
        System.out.println(lastStoneWeight(new int[]{8,9,5,3,8,10,4,5,6,8,20}));
    }
}
