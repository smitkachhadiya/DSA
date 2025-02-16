public class NQueens2 {

    //  52. N-Queens II

    public static int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board,0);
    }

    private static int queens(boolean[][] board, int row){
        if(row == board.length){
            return 1;
        }

        int count=0;

        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // checking vertical
        for (int i=0 ; i <row ; i++){
            if(board[i][col]){
                return false;
            }
        }

        //checking left diagonal
        int maxLeft = Math.min(row,col);
        for(int i=1 ; i <= maxLeft ; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        //checking right diagonal
        int maxRight = Math.min(row,board.length-col-1);
        for(int i=1 ; i <= maxRight ; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("ans : " + totalNQueens(4));
        System.out.println("ans : " + totalNQueens(8));
        System.out.println("ans : " + totalNQueens(6));
    }
}
