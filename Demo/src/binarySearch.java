public class binarySearch {
    public static void main(String[] args) {

//        int arr[] = {1,3,5,9,16,25,36,59,69,88};
        int arr[] = {99,86,75,66,45,42,26,18,8,5,1,0,-1,-22,-39};
        int target = -22;
        int ans = binarySearchFunction(arr , target);
        if(ans == -1){
            System.out.println("Ans is not found inside array");
        }else {
            System.out.println("Answer is at " +ans);
        }
    }

    static int binarySearchFunction(int[] arr , int target){
        int start = 0;
        int end = arr.length - 1;

        // checking if array is in ascending order or not
        boolean isAscending = arr[start] < arr[end];

        while (start <= end){
//            int mid = (start + end) / 2;    //This may exceed the int range
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAscending){
                if(target < arr[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(target < arr[mid]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
