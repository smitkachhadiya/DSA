public class minRecordsOfGetKConsecutiveBlackBlocks {

    //   2379. Minimum Recolors to Get K Consecutive Black Blocks

    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int black = 0;
        int minRecoloring = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if (blocks.charAt(i) == 'B') {
                black++;
            }
            if (i >= k - 1) {
                minRecoloring = Math.min(k - black, minRecoloring);
                if (blocks.charAt(i - k + 1) == 'B') {
                    black--;
                }
            }
        }
        return minRecoloring;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW",7));
        System.out.println(minimumRecolors("WBWBBBW",2));
    }
}
