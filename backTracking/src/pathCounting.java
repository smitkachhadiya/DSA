

import java.util.ArrayList;

public class pathCounting {
    public static void main(String[] args) {
//        System.out.println(totalPath(3,3));
        ArrayList<String> path = new ArrayList<>();
//        printingPath("",3,3,path);
        printingPathDiagonal("",3,3,path);
        System.out.println(path);
    }

    static int totalPath(int r , int d){
        if(r == 1 || d == 1){
            return 1;
        }

        int right = totalPath(r-1,d);
        int down = totalPath(r,d-1);

        return right+down;
    }

    static void printingPath(String p,int r , int d,ArrayList<String> path){
        if(r == 1 && d == 1){
            path.add(p);
            return;
        }
        if(r>1){
            printingPath(p+"R",r-1,d,path);
        }
        if(d>1){
            printingPath(p+"D",r,d-1,path);
        }
    }

    static void printingPathDiagonal(String p,int r , int c,ArrayList<String> path){
        if(r == 1 && c == 1){
            path.add(p);
            return;
        }
        if(r>1 && c>1){
            printingPathDiagonal(p+"V",r-1,c-1,path);
        }
        if(r>1){
            printingPathDiagonal(p+"R",r-1,c,path);
        }
        if(c>1){
            printingPathDiagonal(p+"D",r,c-1,path);
        }
    }
}
