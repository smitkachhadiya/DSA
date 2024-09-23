

import java.util.Arrays;

public class sortUsingRecursion {
    public static void main(String[] args) {
        int arr[] = {1,3,5,6,4,2};
       // bubbleSort(arr,arr.length -1,0);
        selectionSort(arr,arr.length ,0,0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr , int row , int col , int max){
        if(row == 0){
            return;
        }
        if(col < row){
            if(arr[col] > arr[max]){
                selectionSort(arr , row , col +1 , col);
            }else{
                selectionSort(arr , row , col +1 , max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;
            selectionSort(arr , row -1 , 0 , 0);
        }
    }


    static void bubbleSort(int[] arr,int row,int col){
        if(row == 0){
            return;
        }
        if(col < row){
            if(arr[col] > arr[col +1]){
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;
            }

            bubbleSort(arr,row,col + 1);
        }else{
            bubbleSort(arr , row -1 , 0);
        }
    }
}
