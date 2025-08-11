import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rangeProductQueriesOfPowers {

    //  2438. Range Product Queries of Powers

    final static int MOD = 1000000007;

    // Using DP
    public static int[] productQueries(int n, int[][] queries) {
        List<Integer> powList = new ArrayList<>();
        while (n > 0) {
            int lowBit = n & -n;
            powList.add(lowBit);
            n ^= lowBit;
        }
        int size = powList.size();
        int[][] prodTable = new int[size][size];
        for (int row = 0; row < size; row++) {
            prodTable[row][row] = powList.get(row);
            for (int col = row + 1; col < size; col++) {
                prodTable[row][col] = (int)((long)prodTable[row][col - 1] * powList.get(col) % MOD);
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int p = queries[i][0];
            int q = queries[i][1];
            result[i] = prodTable[p][q];
        }
        return result;
    }

    public static int[] productQueries2(int n, int[][] queries) {
        int[] powers = new int[Integer.bitCount(n)];
        for (int i = 0; n > 0; ++i) {
            int x = n & -n;
            powers[i] = x;
            n -= x;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; ++i) {
            long product = 1;
            int l = queries[i][0], r = queries[i][1];
            for (int j = l; j <= r; ++j) {
                product = (product * powers[j]) % MOD;
            }
            ans[i] = (int) product;
        }
        return ans;
    }

    public static int[] productQueries3(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int power = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add(power);
            }
            power <<= 1;
            n >>= 1;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                product = (int)(((long)product * powers.get(j)) % MOD);
            }
            result[i] = product;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productQueries(15,new int[][]{{0,1},{2,2},{0,3}})));
        System.out.println(Arrays.toString(productQueries(132353533, new int[][]{
                {13, 15}, {14, 14}, {14, 14}, {9, 10}, {5, 9}, {1, 15}, {9, 9}, {2, 9},
                {6, 6}, {15, 15}, {9, 14}, {3, 13}, {7, 7}, {0, 5}, {0, 5}, {2, 3},
                {10, 11}, {3, 4}, {15, 15}, {13, 13}, {10, 10}, {8, 9}, {0, 3}, {9, 15},
                {13, 15}, {3, 6}, {5, 10}, {4, 7}, {5, 15}, {3, 10}, {2, 14}, {10, 10},
                {13, 14}, {5, 9}, {10, 13}, {12, 14}, {5, 13}, {1, 2}, {8, 10}, {15, 15},
                {1, 6}, {9, 14}, {7, 7}, {13, 15}, {15, 15}, {6, 7}, {9, 9}, {8, 13},
                {9, 12}, {0, 7}, {0, 1}, {13, 13}, {11, 11}, {7, 13}, {10, 14}, {13, 15},
                {13, 14}, {10, 13}, {5, 15}, {9, 10}
        })));
        System.out.println(Arrays.toString(productQueries(123444423, new int[][]{{6, 14}, {0, 0}})));
    }
}
