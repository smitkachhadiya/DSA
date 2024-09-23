
public class NKnight {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];
        knights(board,0,0,8);
    }

    static void knights(boolean[][] board , int row , int col , int target){
        if(target == 0){
            display(board);
            System.out.println();
            return;
        }

        if(row == board.length-1 && col == board.length){
            return;
        }
        if(col == board.length){
            knights(board , row+1 , 0 , target);
            return;
        }

        if(isSafe(board,row,col)){
            board[row][col] = true;
            knights(board,row,col+1,target-1);
            board[row][col] = false;
        }
        knights(board,row,col+1,target);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        int[] rowMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] colMoves = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];
            if (isValide(board, newRow, newCol) && board[newRow][newCol]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValide(boolean[][] board , int row , int col){
        if(row >=0 && row < board.length && col >=0 && col < board.length){
            return true;
        }
        return false;
    }

    static void display(boolean[][] board){
        for(boolean[] arr : board){
            for(boolean element : arr){
                if(element){
                    System.out.print("K ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
