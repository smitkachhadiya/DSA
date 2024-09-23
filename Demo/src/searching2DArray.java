import java.lang.reflect.Array;
import java.util.Arrays;

public record searching2DArray() {

    public static void main(String[] args) {
        int[][] arr = {
                {1 , 56},
                {56 , 86 , 85},
                {98 , 55 , 23 , 21},
                {65 , 2}
        };
        int target = 55;
        int[] ans = search(arr , target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search (int[][] arr , int target){
        if(arr.length == 0){
            System.out.println("No items in array");
            return new int[]{-1 , -1};
        }
        for (int row=0 ; row < arr.length  ; row++){
            for (int column=0 ; column < arr[row].length ; column++){
                if (arr[row][column] == target){
                    return new int[]{row,column};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
