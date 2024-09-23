
import java.util.Arrays;

public class mergeSortInPlace {
    public static void main(String[] args) {
        int arr[] = {1 , 4 , 6 ,2 ,3 ,5 };
        mergeSort2(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort2(int[] arr , int start , int end){
        if(end - start == 1){
            return;
        }

        int mid = (start + end) / 2;

        mergeSort2(arr , start , mid);
        mergeSort2(arr , mid , end);

        mergeArrays2(arr , start , mid , end);
    }

    private static void mergeArrays2(int[] arr, int start, int mid, int end) {
        int[] ans = new int[end -start];

        int i = start,j=mid,k=0;

        while (i < mid &&  j < end){
            if(arr[i] < arr[j]){
                ans[k] = arr[i];
                i++;
            }else{
                ans[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            ans[k] = arr[i];
            i++;
            k++;
        }
        while (j < end){
            ans[k] = arr[j];
            j++;
            k++;
        }

        for(int l = 0 ;l < ans.length ; l++){
            arr[start + l] = ans[l];
        }
    }
}
