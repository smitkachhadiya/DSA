import java.util.Arrays;

public class setMatrixZeroes {

    // 73. Set Matrix Zeroes

    public static void setZeroes(int[][] matrix) {
        boolean zeroInFirstColumn = false;
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row][0] == 0){
                zeroInFirstColumn = true;
            }

            for (int column = 1; column < matrix[0].length; column++) {
                if(matrix[row][column] == 0){
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }

        for (int row = matrix.length-1 ; row >=0 ; row--) {
            for (int column = matrix[0].length-1 ; column >=1 ; column--) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0){
                    matrix[row][column] = 0;
                }
            }
            if (zeroInFirstColumn){
                matrix[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
