import java.util.Arrays;
import java.util.PriorityQueue;

public class relativeRanks {

    //  506. Relative Ranks

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ranks = new String[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> score[b]-score[a]);

        for (int i = 0; i < n; i++) {
            pq.add(i);
        }

        int i=1;
        while(!pq.isEmpty()){

            int index = pq.poll();
            if(i > 3){
                ranks[index] = Integer.toString(i);
            }else if(i == 1){
                ranks[index] = "Gold Medal";
            }else if(i == 2){
                ranks[index] = "Silver Medal";
            }else if(i == 3){
                ranks[index] = "Bronze Medal";
            }
            i++;
        }

        return ranks;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(findRelativeRanks(new int[]{5,4,3,2,1})));
        System.out.println(Arrays.asList(findRelativeRanks(new int[]{10,5,9,12,45,20,3})));
        System.out.println(Arrays.asList(findRelativeRanks(new int[]{51,2})));
    }

}
