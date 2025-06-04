import java.util.*;

public class maximumCandiesYouCanGetFromBoxes {

    // 1298. Maximum Candies You Can Get from Boxes

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new LinkedList<>();
        for(int start : initialBoxes){
            q.offer(start);
        }

        Set<Integer> closed = new HashSet<>();
        int total = 0;

        while (!q.isEmpty()){
            int current = q.poll();
            if(status[current] == 0){
                closed.add(current);
                continue;
            }

            for (int open : keys[current]){
                status[open] = 1;
                if(closed.contains(open)){
                    q.offer(open);
                    closed.remove(open);
                }
            }

            total += candies[current];
            for(int neighbor : containedBoxes[current]){
                q.offer(neighbor);
            }
        }
        return total;
    }

    public static int maxCandies2(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int total = 0;
        boolean openable = true;
        List<Integer> iBoxes = new ArrayList<>();

        for (int box : initialBoxes){
            iBoxes.add(box);
        }

        while (!iBoxes.isEmpty() && openable){
            openable = false;
            List<Integer> next = new ArrayList<>();
            for(int box : iBoxes){
                if(status[box] == 1){
                    openable = true;

                    for(int nextBox : containedBoxes[box]){
                        next.add(nextBox);
                    }

                    for (int key : keys[box]){
                        status[key] = 1;
                    }

                    total += candies[box];
                } else {
                    next.add(box);
                }
            }
            iBoxes = next;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] status = {1,0,1,0};
        int[] candies = {7,5,4,100};
        int[][] keys = {{},{},{1},{}};
        int[][] containedBoxes = {{1,2},{3},{},{}};
        int[] initialBoxes = {0};

        System.out.println(maxCandies(status , candies , keys , containedBoxes , initialBoxes));
        System.out.println(maxCandies2(status , candies , keys , containedBoxes , initialBoxes));
    }
}
