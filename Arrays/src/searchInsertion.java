public class searchInsertion {

    // 35. Search Insert Position

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }

        int front = 0, rear = nums.length-1;

        while (front <= rear) {
            int mid = front + (rear - front) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                front = mid + 1;
            } else {
                rear = mid - 1;
            }
        }

        return front;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,15,24,36};
        System.out.println(searchInsert(arr , 35));
    }
}
