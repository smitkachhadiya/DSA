import java.util.ArrayList;
import java.util.List;

public class NQueens1 {

    // 51. N-Queens

    public static List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        queens(board,0,result);
        return result;
    }

    private static void queens(boolean[][] board,int row,List<List<String>> result) {
        if(row == board.length){
            result.add(addList(board));
            return;
        }
        for(int col = 0 ; col< board.length ; col++){
            if (isSafe(board , row , col)){
                board[row][col] = true;
                queens(board,row+1,result);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board , int row , int col){
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

    private static List<String> addList(boolean[][] board){
        List<String> ans = new ArrayList<>();
        for (boolean[] arr: board){
            StringBuilder temp = new StringBuilder();
            for (boolean element : arr){
                if(element){
                    temp.append("Q");
                }else {
                    temp.append(".");
                }
            }
            ans.add(temp.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("\nans : " + solveNQueens(4));
        System.out.println("\nans : " + solveNQueens(8));
        System.out.println("\nans : " + solveNQueens(6));
    }
}
