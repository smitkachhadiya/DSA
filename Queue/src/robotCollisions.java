import java.util.*;

public class robotCollisions {

    //  2751. Robot Collisions

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> positions[a] - positions[b]);

        boolean[] dead = new boolean[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i : order) {
            if (directions.charAt(i) == 'R') {
                st.push(i);
            } else {
                while (!st.isEmpty() && directions.charAt(st.peek()) == 'R') {
                    int top = st.peek();
                    if (healths[top] > healths[i]) {
                        healths[top]--;
                        dead[i] = true;
                        break;
                    } else if (healths[top] < healths[i]) {
                        healths[i]--;
                        dead[top] = true;
                        st.pop();
                    } else {
                        dead[i] = dead[top] = true;
                        st.pop(); break;
                    }
                }
                if (!dead[i])
                    st.push(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (!dead[i]) {
                res.add(healths[i]);
            }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{5,4,3,2,1},new int[]{2,17,9,15,10},"RRRRR"));
        System.out.println(survivedRobotsHealths(new int[]{3,5,2,6},new int[]{10,10,15,12},"RLRL"));
    }
}
