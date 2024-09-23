package DSA.src;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int arr[] = {1,3,5,2,6,4,7,5};
        arr = mergeS(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeS(int[] arr){

        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] first = mergeS(Arrays.copyOfRange(arr,0 , mid));
        int[] second = mergeS(Arrays.copyOfRange(arr,mid,arr.length));

        return mergeArrays(first , second);
    }

    static int[] mergeArrays(int[] first , int[] second){
        int[] ans = new int[first.length + second.length];

        int i = 0,j=0,k=0;

        while (i < first.length &&  j < second.length){
            if(first[i] < second[j]){
                ans[k] = first[i];
                i++;
            }else{
                ans[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length){
            ans[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length){
            ans[k] = second[j];
            j++;
            k++;
        }

        return ans;
    }
}
