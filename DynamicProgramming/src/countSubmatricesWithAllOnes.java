public class countSubmatricesWithAllOnes {

    //  1504. Count Submatrices With All Ones

    public static int numSubmat(int[][] mat) {
        int m = mat.length , n = mat[0].length;
        int[] height = new int[n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 1 ? 1 + height[j] : 0;
            }
            for (int j = 0; j < n; j++) {
                int temp = height[j];
                for (int k = j; k >=0 && temp >0 ; k--) {
                    temp = Math.min(temp,height[k]);
                    count+= temp;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubmat(new int[][]{{1,0,0,1,1},{1,1,0,0,1},{1,1,0,1,1}}));
    }
}
