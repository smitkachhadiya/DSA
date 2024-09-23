

import java.util.Arrays;

public class AllDirectionPathPrinting {
    public static void main(String[] args) {
        boolean[][] maze= {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path= new int[maze.length][maze[0].length];

        printPath("",maze,path,0,0,1);
    }

    static void printPath(String p ,boolean[][] maze,int[][] path , int r,int c,int n){
        if(r == maze.length-1 && c == maze[0].length -1){
            System.out.println(p);
            path[r][c] = n;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }else {
            maze[r][c] = false;
            path[r][c] = n;
            if(r > 0){
                printPath(p+"U",maze,path,r-1,c,n+1);
            }
            if(c < maze[0].length -1){
                printPath(p+"R",maze,path,r,c+1,n+1);
            }
            if(c > 0){
                printPath(p+"L",maze,path,r,c-1,n+1);
            }

            if(r < maze.length-1){
                printPath(p+"D",maze,path,r+1,c,n+1);
            }
            maze[r][c] = true;
            path[r][c] = 0;
        }
    }
}
