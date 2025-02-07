import java.util.*;

public class findNumberOfDistinctColorsAmongBalls {

    // 3160. Find the Number of Distinct Colors Among the Balls

    public static int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorsMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        int n = queries.length;
        int [] result = new int[n];

        for(int i = 0; i < n; i++) {

            int index = queries[i][0];
            int color = queries[i][1];

            if(indexMap.containsKey(index)) {

                int oldColor = indexMap.get(index);
                int freq = colorsMap.get(oldColor) - 1;
                if(freq == 0) {
                    colorsMap.remove(oldColor);
                } else {
                    colorsMap.put(oldColor, freq);
                }
            }

            indexMap.put(index, color);
            colorsMap.put(color, colorsMap.getOrDefault(color,0) + 1);

            result[i] = colorsMap.size();
        }

        return result;
    }

    public static void main(String[] args) {
//        int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        int[][] queries = {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}};
        int limit = 4;
        System.out.println(Arrays.toString(queryResults(limit , queries)));
    }
}
