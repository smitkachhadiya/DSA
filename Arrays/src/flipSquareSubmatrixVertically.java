import javax.swing.plaf.synth.SynthOptionPaneUI;

public class flipSquareSubmatrixVertically {

    //  3643. Flip Square Submatrix Vertically

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int sc = y, ec = y + k - 1, sr = x;
        for (int j = sc; j <= ec; j++) {
            for (int i = 0; i < k / 2; i++) {
                int tmp = grid[sr+i][j];
                grid[sr+i][j] = grid[sr+k-i-1][j];
                grid[sr+k-i-1][j] = tmp;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        System.out.println(reverseSubmatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},1,0,3));
        System.out.println(reverseSubmatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},1,2,3));
    }
}
