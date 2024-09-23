public class countingRotationInArray {
    public static void main(String[] args) {

        int[] arr = {10,12,15,18,0,1,2,3};
        int[] arr1 = {10,10,1,2,3,6,7,10};
        int pivot = findPivot(arr);
        int pivot1 = findPivotForDuplicateData(arr1);
        if (pivot == -1){
            System.out.println("Array has not been rotated");
        }else {
            System.out.println("The array has been rotated " + (pivot+1) + " times");
        }

        if (pivot1 == -1){
            System.out.println("Array has not been rotated");
        }else {
            System.out.println("The array has been rotated " + (pivot1+1) + " times");
        }
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid<end &&  arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(mid>start &&   arr[mid] > arr[mid+1]){
                return mid;
            }
            if (arr[mid] <= arr[start]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

     static int findPivotForDuplicateData(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid<end &&  arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(mid>start &&   arr[mid] > arr[mid+1]){
                return mid;
            }

            // if the element at start,mid and end are duplicate then skip it
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                //check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                //check if end is pivot
                if (arr[end] < arr[end - 1]) {
                    return end-1;
                }
                end--;
            }
            //left side is shorted ,  so pivot should be at right side
            else if(arr[start] < arr[mid] || (arr[mid] == arr[start] && arr[mid] > arr[end])){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }
}
