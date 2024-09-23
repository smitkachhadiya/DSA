package DSA.dataSets.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class revealCardInIncreasingOrder {
    // 950. Reveal Cards In Increasing Order

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            queue.add(i);
        }

        for(int i=0 ; i<n ; i++){
            ans[queue.remove()] = deck[i];
            if(queue.isEmpty()){
                break;
            }
            queue.add(queue.remove());
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1000};
        System.out.println(Arrays.toString(deckRevealedIncreasing(arr)));
    }

}
